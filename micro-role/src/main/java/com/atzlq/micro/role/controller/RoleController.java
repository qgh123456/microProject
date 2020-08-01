package com.atzlq.micro.role.controller;

import com.atzlq.micro.common.vo.Result;
import com.atzlq.micro.role.entity.RoleEntity;
import com.atzlq.micro.role.feign.UserClient;
import com.atzlq.micro.role.feign.UserRoleClient;
import com.atzlq.micro.role.service.RoleService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

/**
 * 角色表
 *
 * @author lixianfeng
 * @email lxf@atguigu.com
 * @date 2020-07-31 18:11:51
 */
@Api(tags = "角色表 管理")
@RestController
@RequestMapping("role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserClient userClient;

    @Autowired
    private UserRoleClient userRoleClient;

    @GetMapping("/getUserDetail/{roleId}/{userId}")
    public Result getUserDetail(@PathVariable(value = "roleId") Integer roleId,@PathVariable(value = "userId") Integer userId){

        // 通过角色id获取角色的详细信息
        RoleEntity role = this.roleService.getById(roleId);


        // 通过角色id获取用户角色的关联表信息
        Result userRole = this.userRoleClient.getUserRoleById(roleId, userId);
        // 通过用户id获取用户信息
        Result user = this.userClient.getUserById(userId);
        // 定义返回结果
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("role",role);
        resultMap.put("userRole",userRole);
        resultMap.put("user",user);
        return Result.ok().data(resultMap);
    }

}
