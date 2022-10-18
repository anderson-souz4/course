package com.github.course.services;


import com.github.course.entities.Order;
import com.github.course.repositories.OrderRepository;
import com.github.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findAll(){
        return orderRepository.findAll();
    }

    public Order findById(Long id){
        Optional<Order> byId = orderRepository.findById(id);
        return byId.get();
    }
}

