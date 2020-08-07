package com.atzlq.micro.controller;

import com.atzlq.micro.common.core.vo.Result;
import com.atzlq.micro.entity.UserEntity;
import com.atzlq.micro.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户表
 *
 * @author lixianfeng
 * @email lxf@atguigu.com
 * @date 2020-07-31 18:11:51
 */
@Api(tags = "用户表 管理")
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;



    @GetMapping("/getUserById/{userId}")
    public Result getUserById(Integer userId){
        // 通过userId查询出用户信息
        UserEntity userEntity = this.userService.getById(userId);
        return Result.ok().data(userEntity);

    }

    @GetMapping("/getUser")
    public Result getUser(String account){

        UserEntity user = this.userService.getUser(account);
        return Result.ok().data(user);

    }




}
