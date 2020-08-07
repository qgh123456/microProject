package com.atzlq.micro.controller;

import com.atzlq.micro.common.cache.util.RedisUtil;
import com.atzlq.micro.common.core.util.AesCipherUtil;
import com.atzlq.micro.common.core.util.JwtUtil;
import com.atzlq.micro.common.core.vo.Result;
import com.atzlq.micro.feign.UserClient;
import com.atzlq.micro.vo.UserVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: micro-project
 * @Description:
 * @Author: qiguohui
 * @Date: 2020/8/4 13:55
 */
@RestController
@RequestMapping("auth")
@PropertySource("classpath:config.properties")
public class AuthController {

    @Autowired
    private UserClient userClient;

    @Autowired
    private RedisUtil redisUtil;

    @Value("${accessTokenExpireTime}")
    private Long accessTokenExpireTime;

    @PostMapping("/login")
    public Result login(@RequestBody UserVo userVo, HttpServletRequest request, HttpServletResponse response){

        // 查询数据库中的帐号信息
        Result result = userClient.getUser(userVo.getAccount());
        UserVo userVoTemp = (UserVo)result.getData();
        if(null == userVoTemp){
            return Result.error().data("该帐号不存在(The account does not exist.)");
        }
        // 密码进行AES解密
        String key = AesCipherUtil.deCrypto(userVoTemp.getPassword());
        // 因为密码加密是以帐号+密码的形式进行加密的，所以解密后的对比是帐号+密码
        if (key.equals(userVo.getAccount() + userVo.getPassword())) {
            // 生成token
            String token = JwtUtil.sign(userVo.getAccount());
            if(StringUtils.isNotEmpty(token)){
//                Cookie cookie = new Cookie("token", token);
//                // 设置cookie的过期时间
//                cookie.setMaxAge(accessTokenExpireTime);
//                response.addCookie(cookie);
                // 获取tokenId
                String tokenId = JwtUtil.getClaim(token, "tokenId");
                // 放入到redis中，用于判断
                redisUtil.set(tokenId,token,accessTokenExpireTime);
                return Result.ok().data(token);
            }else {
                return Result.ok().data("系统繁忙，请稍后重试!");
            }
        } else {
            return Result.ok().data("帐号或密码错误(Account or Password Error.)");
        }

    }

    @GetMapping("/getAuth")
    public Result getAuth(@RequestParam(value = "token") String token) {

        // 解析token，获取用户
        String account = JwtUtil.getClaim(token, "account");
        // 从redis中获取改用户对应的权限信息
        Map<Object, Object> accoutMap = redisUtil.hmget("account");
        if (null != accoutMap) {
            return Result.ok().data(accoutMap);
        } else {
            // 查询数据库中的帐号信息
            Result result = userClient.getUser(account);
            UserVo userVo = (UserVo)result.getData();
            // 获取用户对应的详细信息,这里先写死
            Map<String,Object> userMap = new HashMap<>();
            userMap.put("userDetail",userVo);
            Map<String,Object> permissionMap = new HashMap<>();
            permissionMap.put("id",1);
            permissionMap.put("name","查看用户");
            permissionMap.put("perCode","user:view");
            permissionMap.put("perUrl","/role/getUserDetail/{roleId}/{userId}");
            userMap.put("permission",permissionMap);
            // 把用户的角色权限信息放到redis中
            redisUtil.hmset("account",userMap);
            return Result.ok().data(userMap);
        }
    }
}
