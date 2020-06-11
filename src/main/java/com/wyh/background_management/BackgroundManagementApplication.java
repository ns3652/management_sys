package com.wyh.background_management;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wyh.background_management.dao")
public class BackgroundManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackgroundManagementApplication.class, args);
    }

}
