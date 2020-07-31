package com.atzlq.micro.role.service.Impl;

import com.atzlq.micro.role.dao.RoleDao;
import com.atzlq.micro.role.entity.RoleEntity;
import com.atzlq.micro.role.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service("roleService")
public class RoleServiceImpl extends ServiceImpl<RoleDao, RoleEntity> implements RoleService {



}