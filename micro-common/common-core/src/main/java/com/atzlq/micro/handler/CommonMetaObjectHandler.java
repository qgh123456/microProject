package com.atzlq.micro.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @ProjectName: microProject
 * @Description:
 * @Author: qiguohui
 * @Date: 2020/7/30 16:51
 */
@Component
@Slf4j
public class CommonMetaObjectHandler implements MetaObjectHandler {

    public void insertFill(MetaObject metaObject) {
        log.info("start insert fill ....");
        this.setFieldValByName("gmtCreate", new Date(), metaObject);//自动添加数据（插入）
        this.setFieldValByName("gmtModified", new Date(), metaObject);//自动添加数据（插入）
    }

    public void updateFill(MetaObject metaObject) {
        log.info("start update fill ....");
        this.setFieldValByName("gmtModified", new Date(), metaObject);//自动添加数据（修改）
    }
}