package com.atzlq.micro.user.controller;

import com.atzlq.micro.common.vo.Result;
import com.atzlq.micro.user.entity.UserEntity;
import com.atzlq.micro.user.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

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

}
