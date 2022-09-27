package com.roadhog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.roadhog.mapper")
public class SpringBootMybatisplusApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMybatisplusApplication.class, args);
    }

}
