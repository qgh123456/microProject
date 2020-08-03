//package com.atzlq.micro.common.cache.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * @ProjectName: micro-project
// * @Description:
// * @Author: qiguohui
// * @Date: 2020/8/3 14:33
// */
//@RestController
//@RequestMapping("test")
//public class Acontroller {
//
//    @Autowired
//    private RedisTemplate redisTemplate;
//
//    @RequestMapping("/a")
//    public String a(String key,String value){
//        redisTemplate.opsForValue().set(key,value);
//        return "a";
//    }
//}
