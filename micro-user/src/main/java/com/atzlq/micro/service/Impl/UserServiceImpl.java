package com.atzlq.micro.service.Impl;

import com.atzlq.micro.dao.UserDao;
import com.atzlq.micro.entity.UserEntity;
import com.atzlq.micro.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;


@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, UserEntity> implements UserService {


}