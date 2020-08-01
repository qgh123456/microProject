package com.atzlq.micro.userRole.controller;

import com.atzlq.micro.common.vo.Result;
import com.atzlq.micro.userRole.service.UserRoleService;
import com.atzlq.micro.userrole.entity.UserRoleEntity;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Wrapper;
import java.util.Map;

/**
 * 用户角色表
 *
 * @author lixianfeng
 * @email lxf@atguigu.com
 * @date 2020-07-31 18:11:51
 */
@Api(tags = "用户角色表 管理")
@RestController
@RequestMapping("userrole")
public class UserRoleController {

    @Autowired
    private UserRoleService userRoleService;

    @GetMapping("/getUserRoleById/{userId}/{roleId}")
    public Result getUserRoleById(@PathVariable(value = "userId") Integer userId, @PathVariable(value = "roleId") Integer roleId){

        // 构建查询条件对象
        QueryWrapper<UserRoleEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id",userId);
        queryWrapper.eq("role_id",roleId);
        UserRoleEntity userRoleEntity = this.userRoleService.getOne(queryWrapper);
        return Result.ok().data(userRoleEntity);

    }

}
