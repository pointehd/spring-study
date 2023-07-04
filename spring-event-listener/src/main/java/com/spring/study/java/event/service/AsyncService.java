package com.spring.study.java.event.service;


import com.spring.study.java.event.entity.SubTable;
import com.spring.study.java.event.repository.SubRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AsyncService {

    private final SubRepository repository;

    @Async
    public void async() {
        log.info("async thread : {}, ", Thread.currentThread().getId());
        repository.save(SubTable.of("aync!"));
        if (1 == 1) {
            throw new RuntimeException("");
        }
    }
}
