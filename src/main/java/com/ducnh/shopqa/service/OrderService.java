package com.ducnh.shopqa.service;

import org.springframework.stereotype.Service;

import com.ducnh.shopqa.entity.Order;
import com.ducnh.shopqa.repo.OrderRepository;

@Service
public class OrderService {
    private OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void createOrder(Order order) {
        orderRepository.save(order);
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    public void updateOrder(Order order) {
        orderRepository.save(order);
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    public Iterable<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
