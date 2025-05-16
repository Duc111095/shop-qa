package com.ducnh.shopqa.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ducnh.shopqa.entity.Delivery;

@Repository
public interface DeliveryRepository extends CrudRepository<Delivery, Long> {

}
