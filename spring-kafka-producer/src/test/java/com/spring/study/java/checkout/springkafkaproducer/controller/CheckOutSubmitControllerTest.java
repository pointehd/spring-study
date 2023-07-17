package com.spring.study.java.checkout.springkafkaproducer.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
class CheckOutSubmitControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testPostSubmitCheckOut() throws Exception {
        mockMvc.perform(post("/submitCheckOut")
                        .param("memberId", "100001")
                        .param("productId", "200001")
                        .param("amount", "33000")
                        .param("address", "546")
                ).andExpect(status().isOk())
                .andDo(print());

    }

}