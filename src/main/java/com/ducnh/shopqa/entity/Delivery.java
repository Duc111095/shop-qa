package com.ducnh.shopqa.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "delivery")
@Data
public class Delivery { 
    private String id;
    private String userId;
    private String cartId;
    private String shippingAddress;
    private String status;
    private LocalDateTime createdAt;
}
