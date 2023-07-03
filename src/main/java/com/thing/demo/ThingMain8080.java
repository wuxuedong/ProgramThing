package com.thing.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.thing.demo.mapper")
public class ThingMain8080 {
    public static void main(String[] args) {
        SpringApplication.run(ThingMain8080.class,args);
    }
}
