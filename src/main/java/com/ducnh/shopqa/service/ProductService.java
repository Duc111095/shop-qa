package com.ducnh.shopqa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ducnh.shopqa.entity.Product;
import com.ducnh.shopqa.payload.ProductRequest;
import com.ducnh.shopqa.repo.ProductRepository;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product updateProduct(Long id, ProductRequest product) {
        Product existingProduct = productRepository.findById(id).orElse(null);
        if (existingProduct == null) {
            return null;
        }
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setDiscount(product.getDiscount());
        existingProduct.setCategory(product.getCategory());
        existingProduct.setType(product.getType());
        existingProduct.setMaterial(product.getMaterial());
        existingProduct.setImage(product.getImage());
        existingProduct.setSize(product.getSize());
        return productRepository.save(existingProduct);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
