package com.spring.study.java.event.service;

import com.spring.study.java.event.dto.EventData;
import com.spring.study.java.event.entity.SubTable;
import com.spring.study.java.event.repository.SubRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Service
public class TestService {

    private final SubRepository subRepository;

    private final ApplicationEventPublisher publisher;

    @Transactional
    public String transactionPublisher(String name) {
        log.info("log : {}, thread : {}", name, Thread.currentThread().getId());
        subRepository.save(SubTable.of(name+"1"));
        publisher.publishEvent(new EventData(name));
        return name;
    }

}
