package com.ducnh.shopqa.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ducnh.shopqa.entity.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

}