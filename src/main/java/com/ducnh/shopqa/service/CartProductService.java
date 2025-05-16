package com.ducnh.shopqa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ducnh.shopqa.repo.CartProductRepository;

@Service
public class CartProductService {
    @Autowired
    private CartProductRepository cartProductRepository;
}
