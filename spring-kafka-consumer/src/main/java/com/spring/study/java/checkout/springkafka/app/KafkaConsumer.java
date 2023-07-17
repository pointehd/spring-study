package com.spring.study.java.checkout.springkafka.app;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.study.java.checkout.springkafka.dto.CheckOutDto;
import com.spring.study.java.checkout.springkafka.service.SaveService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class KafkaConsumer {

    private static final String TOPIC_NAME = "checkout.complete.v1";

    private static final String GROUP_ID = "shipment.group.v1";

    private final SaveService saveService;

    private final ObjectMapper objectMapper = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    @KafkaListener(topics = TOPIC_NAME, groupId = GROUP_ID)
    public void recordListener(String jsonMessage) {
        try {
            CheckOutDto checkOutDto = objectMapper.readValue(jsonMessage, CheckOutDto.class);
            log.info("consumer checkOutDto : {}", checkOutDto);
            saveService.saveCheckOutData(checkOutDto);
        } catch (JsonProcessingException e) {
            log.error("recordListener ERROR message = {}", jsonMessage, e);
        }
    }
}
