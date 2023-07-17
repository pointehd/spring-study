package com.spring.study.java.checkout.springkafka.controller;

import com.spring.study.java.checkout.springkafka.dto.CheckOutDto;
import com.spring.study.java.checkout.springkafka.service.SaveService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@RequiredArgsConstructor
@Controller
public class CheckOutSubmitController {

    private final SaveService saveService;

    @PostMapping("/submitCheckOut")
    public String submitCheckOut(CheckOutDto checkOutDto, Model model) {
        log.info("checkOutDto : {}", checkOutDto);
        Long checkoutId = saveService.saveCheckOutData(checkOutDto);
        model.addAttribute("checkOutId", checkoutId);

        return "submitComplete";
    }
}
