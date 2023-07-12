package com.spring.study.java.web.flux.springwebflux.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;


@ToString
@Getter
@RequiredArgsConstructor
public class Customer {
    @Id
    private Long id;
    private final String firstName;
    private final String lastName;
}
