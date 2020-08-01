package com.atzlq.micro.role;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableDiscoveryClient
@EnableFeignClients
@MapperScan(basePackages = "com.atzlq.micro.role.**.dao")
public class MicroRoleApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroRoleApplication.class, args);
    }

}
