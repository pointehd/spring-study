package com.spring.study.java.checkout.springkafkaproducer.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckOutRepository extends JpaRepository<CheckOutEntity, Long> {
}
