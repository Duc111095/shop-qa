package com.ducnh.shopqa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ducnh.shopqa.entity.Delivery;
import com.ducnh.shopqa.repo.DeliveryRepository;

@Service
public class DeliveryService {
    @Autowired
    private DeliveryRepository deliveryRepository;

    public Iterable<Delivery> getAllDeliveries() {
        return deliveryRepository.findAll();
    }

    public Delivery getDeliveryById(Long id) {
        return deliveryRepository.findById(id).orElse(null);
    }

    public void createDelivery(Delivery delivery) {
        deliveryRepository.save(delivery);
    }

    public void updateDelivery(Delivery delivery) {
        deliveryRepository.save(delivery);
    }

    public void deleteDeliveryById(Long id) {
        deliveryRepository.deleteById(id);
    }
}
