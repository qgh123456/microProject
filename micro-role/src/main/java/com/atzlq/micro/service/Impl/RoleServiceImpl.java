package com.atzlq.micro.service.Impl;

import com.atzlq.micro.dao.RoleDao;
import com.atzlq.micro.entity.RoleEntity;
import com.atzlq.micro.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service("roleService")
public class RoleServiceImpl extends ServiceImpl<RoleDao, RoleEntity> implements RoleService {


}