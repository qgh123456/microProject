package com.atzlq.micro.userRole;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableDiscoveryClient
//@EnableFeignClients
@MapperScan(basePackages = "com.atzlq.micro.userRole.**.dao")
public class MicroUserroleApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroUserroleApplication.class, args);
    }

}
