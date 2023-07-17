package com.spring.study.java.checkout.springkafka.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckOutRepository extends JpaRepository<CheckOutEntity, Long> {
}
