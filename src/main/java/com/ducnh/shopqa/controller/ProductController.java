package com.ducnh.shopqa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ducnh.shopqa.entity.Product;
import com.ducnh.shopqa.payload.ProductRequest;
import com.ducnh.shopqa.service.ProductService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;



@RestController
@RequestMapping("/products")
public class ProductController {
    
    @Autowired
    private ProductService productService;

    @GetMapping("")
    public ResponseEntity<Iterable<Product>> getProducts() {
        Iterable<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable String id) {
        Product product = productService.getProductById(Long.parseLong(id));
        if (product != null) {
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable String id, @RequestBody ProductRequest entity) {
        try {
            productService.updateProduct(Long.parseLong(id), entity);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Unable to update product");
        }
        return ResponseEntity.ok("Product updated successfully");
    }

    @PostMapping("")
    public ResponseEntity<String> createProduct(@RequestBody ProductRequest entity) {
        try {
            Product product = new Product();
            product.setName(entity.getName());
            product.setPrice(entity.getPrice());
            product.setDiscount(entity.getDiscount());
            product.setCategory(entity.getCategory());
            product.setType(entity.getType());
            product.setMaterial(entity.getMaterial());
            product.setImage(entity.getImage());
            product.setSize(entity.getSize());
            productService.createProduct(product);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Unable to create product");
        }
        return ResponseEntity.ok("Product updated successfully");
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable String id) {
        try {
            productService.deleteProduct(Long.parseLong(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Unable to delete product");
        }
        return ResponseEntity.ok("Product deleted successfully");
    }
}
