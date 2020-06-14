package com.wyy22.wyy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.wyy22.wyy.mapping")
@SpringBootApplication
public class WyyApplication {

    public static void main(String[] args) {
        SpringApplication.run(WyyApplication.class, args);
    }

}
