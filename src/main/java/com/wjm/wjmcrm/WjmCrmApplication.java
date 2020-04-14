package com.wjm.wjmcrm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wjm.wjmcrm.mapper")
public class WjmCrmApplication {

    public static void main(String[] args) {
        SpringApplication.run(WjmCrmApplication.class, args);
    }

}
