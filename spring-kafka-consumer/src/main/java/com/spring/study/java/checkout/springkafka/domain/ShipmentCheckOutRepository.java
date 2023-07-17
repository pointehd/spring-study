package com.spring.study.java.checkout.springkafka.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipmentCheckOutRepository extends JpaRepository<ShipmentCheckOutEntity, Long> {
}
