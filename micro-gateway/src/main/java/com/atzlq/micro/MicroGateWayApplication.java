package com.atzlq.micro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ProjectName: micro-project
 * @Description:
 * @Author: qiguohui
 * @Date: 2020/8/2 16:54
 */
@SpringBootApplication
@EnableDiscoveryClient
public class MicroGateWayApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroGateWayApplication.class, args);
    }
}
