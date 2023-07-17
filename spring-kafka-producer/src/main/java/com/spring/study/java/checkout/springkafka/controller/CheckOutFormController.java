package com.spring.study.java.checkout.springkafka.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class CheckOutFormController {

    @GetMapping("/checkOutForm")
    public String checkOutForm() {
        log.info("checkOutForm........");
        return "checkOutForm";
    }

}
