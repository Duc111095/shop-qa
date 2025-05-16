package com.ducnh.shopqa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ducnh.shopqa.entity.Delivery;
import com.ducnh.shopqa.service.DeliveryService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/delivery")
public class DeliveryController {
    
    @Autowired
    private DeliveryService deliveryService;

    @GetMapping("")
    public ResponseEntity<Iterable<Delivery>> getAllDeliveries() {
        return ResponseEntity.ok(deliveryService.getAllDeliveries());
    }
    
    @GetMapping("/id")
    public ResponseEntity<Delivery> getDeliveryById(Long id) {
        return ResponseEntity.ok(deliveryService.getDeliveryById(id));
    }

    @PostMapping("")
    public ResponseEntity<Void> createDelivery(@RequestBody Delivery delivery) {
        deliveryService.createDelivery(delivery);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateDelivery(@PathVariable Long id, @RequestBody Delivery delivery) {
        deliveryService.updateDelivery(delivery);
        return ResponseEntity.ok().build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDeliveryById(@PathVariable Long id) {
        deliveryService.deleteDeliveryById(id);
        return ResponseEntity.ok().build();
    }
}
