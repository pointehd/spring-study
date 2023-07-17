package com.spring.study.java.checkout.springkafka.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class CheckOutDto {
    private Long checkOutId;
    private Long memberId;
    private Long productId;
    private Long amount;
    private String address;
    private Date createdAt;
}
