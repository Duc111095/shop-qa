package com.ducnh.shopqa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ducnh.shopqa.entity.Cart;
import com.ducnh.shopqa.service.CartService;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    CartService cartService;

    @GetMapping("")
    public ResponseEntity<List<Cart>> getAllCarts() {
        return ResponseEntity.ok(cartService.getAllCarts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cart> getCartById(@PathVariable String id) {
        return ResponseEntity.ok(cartService.getCartById(id));
    }

    @GetMapping("?userId={userId}")
    public ResponseEntity<List<Cart>> getAllCartByUserID(@RequestParam Long userID) {
        return ResponseEntity.ok(cartService.getCartByUserId(userID));
    }
    
    @PostMapping("")
    public ResponseEntity<Void> addCart(@RequestBody Cart cart) {
        cartService.addToCart(cart.getUserId());
        return ResponseEntity.ok().build();
    }

    @PostMapping("")
    public ResponseEntity<Void> addCart(@RequestBody Long userId) {
        cartService.addToCart(userId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cart> updateCart(@PathVariable String id, @RequestBody Cart cart) {
        cartService.updateCart(id, cart.getUserId());
        return ResponseEntity.ok(cart);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteCartById(@RequestParam String cartId) {
        cartService.deleteCartById(cartId);
        return ResponseEntity.ok().build();
    }
    
}
