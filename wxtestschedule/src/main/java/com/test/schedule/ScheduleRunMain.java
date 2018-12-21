package com.test.schedule;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan(basePackages ={"com.test"} )
@MapperScan(basePackages = {"com.test.common.dao.*"})
public class ScheduleRunMain extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(ScheduleRunMain.class, args);
    }
}
