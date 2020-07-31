package com.atzlq.micro.role.service.Impl;

import com.atzlq.micro.role.dao.UserRoleDao;
import com.atzlq.micro.role.entity.UserRoleEntity;
import com.atzlq.micro.role.service.UserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service("userRoleService")
public class UserRoleServiceImpl extends ServiceImpl<UserRoleDao, UserRoleEntity> implements UserRoleService {


}