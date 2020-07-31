package com.atzlq.micro.role.controller;

import com.atzlq.micro.role.service.RoleService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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


}
