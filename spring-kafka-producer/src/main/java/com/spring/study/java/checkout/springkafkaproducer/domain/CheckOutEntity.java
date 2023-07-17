package com.spring.study.java.checkout.springkafkaproducer.domain;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Data
@Table(name = "CHECKOUT_TABLE")
@Entity
public class CheckOutEntity {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long checkOutId;
    private Long memberId;
    private Long productId;
    private Long amount;
    private String address;
    @CreationTimestamp
    private Timestamp createAt;

}
