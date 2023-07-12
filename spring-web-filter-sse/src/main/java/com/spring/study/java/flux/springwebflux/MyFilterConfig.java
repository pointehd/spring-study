package com.spring.study.java.flux.springwebflux;

import jakarta.servlet.Filter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@RequiredArgsConstructor
@Configuration
public class MyFilterConfig {

    private final EventNotify eventNotify;

    @Bean
    public FilterRegistrationBean<Filter> addFilter() {
        log.info("add Filter");
        FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<>(new MyFilter(eventNotify));
        bean.addUrlPatterns("/sse");
        return bean;
    }

    @Bean
    public FilterRegistrationBean<Filter> addFilter2() {
        log.info("add Filter add");
        FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<>(new MyFilterAdd(eventNotify));
        bean.addUrlPatterns("/add");
        return bean;
    }
}
