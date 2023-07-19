package com.nelio.udemy.project.services;

import com.nelio.udemy.project.entities.Order;
import com.nelio.udemy.project.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> findAll() {return orderRepository.findAll();}

    public Order findById(Long id) {
        Optional<Order> order = orderRepository.findById(id);

        if(order.isPresent()) return order.get();

        else
            throw new IllegalArgumentException("Order not found !");
    }
}
