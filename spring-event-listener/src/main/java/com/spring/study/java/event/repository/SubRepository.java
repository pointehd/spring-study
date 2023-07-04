package com.spring.study.java.event.repository;

import com.spring.study.java.event.entity.SubTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubRepository extends JpaRepository<SubTable, Long> {
}
