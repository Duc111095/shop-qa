package com.ducnh.shopqa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ducnh.shopqa.entity.CartProduct;
import com.ducnh.shopqa.repo.CartProductRepository;

@Service
public class CartProductService {
    @Autowired
    private CartProductRepository cartProductRepository;

    public void addProductToCart(CartProduct cartProduct) {
        cartProductRepository.save(cartProduct);
    }

    public void removeProductFromCart(Long cartId, Long productId) {
        cartProductRepository.deleteByCartIdAndProductId(cartId, productId);
    }

    public List<CartProduct> getAllCartProducts() {
        return (List<CartProduct>) cartProductRepository.findAll();
    }

    public CartProduct getCartProductById(Long cartProductId) {
        return cartProductRepository.findById(cartProductId).orElse(null);
    }
    
    public List<CartProduct> getCartProductsByCartId(String cartId) {
        return cartProductRepository.findByCartId(cartId);
    }

    public List<CartProduct> getCartProductsByProductId(Long productId) {
        return cartProductRepository.findByProductId(productId);
    }
    public void updateCartProduct(CartProduct cartProduct) {
        cartProductRepository.save(cartProduct);
    }
    public void deleteCartProductById(Long cartProductId) {
        cartProductRepository.deleteById(cartProductId);
    }
}
