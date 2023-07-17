package com.spring.study.java.checkout.springkafka.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.study.java.checkout.springkafka.domain.ShipmentCheckOutEntity;
import com.spring.study.java.checkout.springkafka.domain.ShipmentCheckOutRepository;
import com.spring.study.java.checkout.springkafka.dto.CheckOutDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class SaveService {

    private final ObjectMapper objectMapper = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    private final ModelMapper modelMapper = new ModelMapper();

    private final ShipmentCheckOutRepository shipmentCheckOutRepository;

    private final KafkaTemplate<String, String> kafkaTemplate;


    public Long saveCheckOutData(CheckOutDto checkOutDto) {
        ShipmentCheckOutEntity shipmentCheckOutEntity = modelMapper.map(checkOutDto, ShipmentCheckOutEntity.class);
        ShipmentCheckOutEntity savedEntity =  shipmentCheckOutRepository.save(shipmentCheckOutEntity);
        return savedEntity.getShipmentId();
    }

}
