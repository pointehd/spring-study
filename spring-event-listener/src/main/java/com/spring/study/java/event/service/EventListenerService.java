package com.spring.study.java.event.service;

import com.spring.study.java.event.dto.EventData;
import com.spring.study.java.event.entity.SubTable;
import com.spring.study.java.event.repository.SubRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionalEventListener;

@Slf4j
@RequiredArgsConstructor
@Component
public class EventListenerService {

    private final SubRepository subRepository;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @TransactionalEventListener(EventData.class)
//    @Async
    public void eventListener(EventData data) {
        log.info("log : {}, thread : {}", data, Thread.currentThread().getId());
        subRepository.save(SubTable.of(data.getName()));

        log.info("save user :{}", data.getName());
    }


}
