package com.spring.study.java.web.flux.springwebflux.api;

import com.spring.study.java.web.flux.springwebflux.domain.Customer;
import com.spring.study.java.web.flux.springwebflux.domain.CustomerRepository;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import static org.mockito.Mockito.*;


@WebFluxTest(controllers = CustomerController.class)
class CustomerControllerTest {

    @MockBean
    CustomerRepository customerRepository;

    @Autowired
    private WebTestClient webClient;

    @Test
    void 한건_찾기_테스트() {
        when(customerRepository.findById(1L)).thenReturn(Mono.just(new Customer("donghyun", "Hwnag")));

        webClient.get()
                .uri("/customer/{id}", 1L)
                .header(HttpHeaders.ACCEPT, "application/json")
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody(Customer.class);

        verify(customerRepository, times(1)).findById(1L);

    }

}