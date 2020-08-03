package com.atzlq.micro.service.Impl;

import com.atzlq.micro.dao.UserRoleDao;
import com.atzlq.micro.service.UserRoleService;
import com.atzlq.micro.entity.UserRoleEntity;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service("userRoleService")
public class UserRoleServiceImpl extends ServiceImpl<UserRoleDao, UserRoleEntity> implements UserRoleService {


}