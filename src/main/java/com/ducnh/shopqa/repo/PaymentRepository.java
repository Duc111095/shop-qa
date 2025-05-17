package com.ducnh.shopqa.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ducnh.shopqa.entity.Payment;

@Repository
public interface PaymentRepository extends CrudRepository<Payment, Long> {
}
