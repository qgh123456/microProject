package com.atzlq.micro.service.Impl;

import com.atzlq.micro.dao.UserDao;
import com.atzlq.micro.entity.UserEntity;
import com.atzlq.micro.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, UserEntity> implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserEntity getUser(String account) {

        // 构造查询条件
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("account",account);
        UserEntity userEntity = this.userDao.selectOne(queryWrapper);
        return userEntity;
    }
}