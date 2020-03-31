package com.nefu.carbage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.nefu.carbage.mapper")
public class CarbageApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarbageApplication.class, args);
    }

}
