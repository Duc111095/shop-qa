package com.ducnh.shopqa.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "cart")
@Data
public class Cart {
    @Id
    private String id;
    private Long userId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Cart() {
    }

    public Cart(String id, Long userId, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.userId = userId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
