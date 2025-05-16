package com.ducnh.shopqa.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ducnh.shopqa.entity.Cart;
import com.ducnh.shopqa.repo.CartRepository;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;

    public void addToCart(Long userId) {
        String cartId = cartRepository.findMaxCartId();
        if (cartId == null || cartId.isEmpty()) {
            cartId = "cart0001";
        } else {
            String suffix = "0000" + String.valueOf(Long.parseLong(cartId.substring(4) + 1));
            cartId = "cart" + suffix.substring(suffix.length() - 4);
        }
        cartRepository.save(new Cart(cartId, userId, LocalDateTime.now(), LocalDateTime.now()));
    }

    public List<Cart> getCartByUserId(Long userId) {
        return cartRepository.findByUserId(userId);
    }

    public Cart getCartById(String cartId) {
        return cartRepository.findById(cartId).orElse(null);
    }

    public List<Cart> getAllCarts() {
        return (List<Cart>) cartRepository.findAll();
    }

    public void deleteCartById(String cartId) {
        cartRepository.deleteById(cartId);
    }

    public void deleteAllCartsByUserId(Long userId) {
        List<Cart> carts = cartRepository.findByUserId(userId);
        for (Cart cart : carts) {
            cartRepository.delete(cart);
        }
    }

    public void updateCart(String cartId, Long userId) {
        Cart cart = cartRepository.findById(cartId).orElse(null);
        if (cart != null) {
            cart.setUserId(userId);
            cart.setUpdatedAt(LocalDateTime.now());
            cartRepository.save(cart);
        }
    }
}
