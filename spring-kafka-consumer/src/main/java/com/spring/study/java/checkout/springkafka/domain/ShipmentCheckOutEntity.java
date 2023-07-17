package com.spring.study.java.checkout.springkafka.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Data
@Entity
public class ShipmentCheckOutEntity {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long shipmentId;
    private Long checkOutId;
    private Long memberId;
    private Long productId;
    private Long amount;
    private String address;
    @CreationTimestamp
    private Timestamp createAt;
}
