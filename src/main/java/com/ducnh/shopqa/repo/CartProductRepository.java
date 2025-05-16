package com.ducnh.shopqa.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ducnh.shopqa.entity.CartProduct;

@Repository
public interface CartProductRepository extends CrudRepository<CartProduct, Long> {
    List<CartProduct> findByCartId(String cartId);
    List<CartProduct> findByProductId(Long productId);
}
