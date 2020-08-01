package com.atzlq.micro.userRole.service.Impl;

import com.atzlq.micro.userRole.dao.UserRoleDao;
import com.atzlq.micro.userRole.service.UserRoleService;
import com.atzlq.micro.userrole.entity.UserRoleEntity;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service("userRoleService")
public class UserRoleServiceImpl extends ServiceImpl<UserRoleDao, UserRoleEntity> implements UserRoleService {


}