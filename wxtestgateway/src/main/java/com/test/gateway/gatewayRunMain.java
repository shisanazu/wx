package com.test.gateway;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.test"})
@MapperScan(basePackages = {"com.test.common.dao.*"})
public class gatewayRunMain extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(gatewayRunMain.class, args);
    }
}
