package com.atzlq.micro.service;

import com.atzlq.micro.entity.UserEntity;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 用户表
 *
 */
public interface UserService extends IService<UserEntity> {

    UserEntity getUser(String account);



}

