package com.atzlq.micro.role;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.atzlq.micro.user.**.mapper")
public class MicroRoleApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroRoleApplication.class, args);
    }

}
