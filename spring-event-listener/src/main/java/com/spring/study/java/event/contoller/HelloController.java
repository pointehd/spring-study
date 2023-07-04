package com.spring.study.java.event.contoller;

import com.spring.study.java.event.service.TestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class HelloController {

    private final TestService testService;

    @GetMapping("/{name}")
    public String syncTest(@PathVariable String name) {
        String result = testService.transactionPublisher(name);
        log.info("controller");
        return result;
    }
}
