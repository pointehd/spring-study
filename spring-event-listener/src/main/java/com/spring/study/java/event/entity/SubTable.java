package com.spring.study.java.event.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "sub_test")
@Entity
public class SubTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    private SubTable(String name) {
        this.name = name;
    }
    public static SubTable of(String name) {
        return new SubTable(name);
    }
}
