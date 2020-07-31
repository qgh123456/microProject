package com.atzlq.micro.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 *  这个地方
 */
@SpringBootApplication
@EnableSwagger2
@EnableDiscoveryClient
//@EnableFeignClients
@MapperScan(basePackages = "com.atzlq.micro.user.**.dao")
public class MicroUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroUserApplication.class, args);
    }

}
