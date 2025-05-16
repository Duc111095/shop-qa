package com.ducnh.shopqa.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ducnh.shopqa.entity.Cart;

@Repository
public interface CartRepository extends CrudRepository<Cart, String> {
    List<Cart> findByUserId(Long userId);
    @Query(nativeQuery = true, value =  "SELECT MAX(cartId) as max_id FROM Cart")
    String findMaxCartId();
}