package com.spring.study.java.checkout.springkafka.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.study.java.checkout.springkafka.domain.CheckOutEntity;
import com.spring.study.java.checkout.springkafka.domain.CheckOutRepository;
import com.spring.study.java.checkout.springkafka.dto.CheckOutDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Slf4j
@RequiredArgsConstructor
public class SaveService {

    private static final  String CHECKOUT_COMPLETED_TOPIC_NAME = "checkout.complete.v1";
    private final ObjectMapper objectMapper = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    private final ModelMapper modelMapper = new ModelMapper();

    private final CheckOutRepository checkOutRepository;

    private final KafkaTemplate<String, String> kafkaTemplate;


    public Long saveCheckOutData(CheckOutDto checkOutDto) {
        CheckOutEntity checkOutEntity = saveDatabase(checkOutDto);
        checkOutDto.setCheckOutId(checkOutEntity.getCheckOutId());
        checkOutDto.setCreatedAt(new Date(checkOutEntity.getCreateAt().getTime()));
        sendToKafka(checkOutDto);
        return checkOutEntity.getCheckOutId();
    }


    private CheckOutEntity saveDatabase(CheckOutDto checkOutDto) {
        CheckOutEntity checkOutEntity = modelMapper.map(checkOutDto, CheckOutEntity.class);
        return checkOutRepository.save(checkOutEntity);
    }


    private void sendToKafka(CheckOutDto checkOutDto) {
        try {
            String jsonInString  = objectMapper.writeValueAsString(checkOutDto);
            kafkaTemplate.send(CHECKOUT_COMPLETED_TOPIC_NAME, jsonInString);
            log.info("success sendToKafka");
        } catch (JsonProcessingException e) {
            log.error("sendToKafka", e);
        }
    }

}
