package com.atzlq.micro.user.service.Impl;

import com.atzlq.micro.user.dao.UserDao;
import com.atzlq.micro.user.entity.UserEntity;
import com.atzlq.micro.user.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;


@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, UserEntity> implements UserService {


}