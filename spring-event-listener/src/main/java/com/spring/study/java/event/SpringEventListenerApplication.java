package com.spring.study.java.event;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class SpringEventListenerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringEventListenerApplication.class, args);
    }

}
