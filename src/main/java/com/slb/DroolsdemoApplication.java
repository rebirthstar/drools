package com.slb;

import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.mybatis.spring.annotation.MapperScan;
@SpringBootApplication
@MapperScan(basePackages = "com.slb.*")
public class DroolsdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DroolsdemoApplication.class, args);
    }
}
