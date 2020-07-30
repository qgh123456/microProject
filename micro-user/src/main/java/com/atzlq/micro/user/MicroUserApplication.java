package com.atzlq.micro.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableDiscoveryClient
@RefreshScope
//@EnableFeignClients
@MapperScan(basePackages = "com.atzlq.micro.user.**.mapper")
public class MicroUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroUserApplication.class, args);
    }

}
