package com.spring.study.java.web.flux.springwebflux.domain;

import com.spring.study.java.web.flux.springwebflux.config.DBInit;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.r2dbc.DataR2dbcTest;
import org.springframework.context.annotation.Import;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataR2dbcTest
//@Import(DBInit.class)
class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void 한건찾기_테스트() {
        insertPlayers();
        StepVerifier.create(customerRepository.findById(1L))
                .expectNextMatches((c) -> c.getFirstName().equals("Donghyun"))
                .expectComplete()
                .verify();
    }

    private void insertPlayers() {
        List<Customer> players = List.of(
                new Customer("Donghyun", "Dong"),
                new Customer("AAA", "BBB")
        );
        customerRepository.saveAll(players).subscribe();
    }

}