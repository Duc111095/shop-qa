package com.ducnh.shopqa.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ducnh.shopqa.entity.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
    
}
