package com.github.course.resources;

import com.github.course.entities.Order;
import com.github.course.entities.User;
import com.github.course.repositories.UserRepository;
import com.github.course.services.OrderService;
import com.github.course.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {

    @Autowired
    OrderService orderService;

    @Autowired
    UserRepository repository;

    @GetMapping
    public ResponseEntity<List<Order>> findAll(){
        List<Order> list = orderService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Order> findById(@PathVariable Long id){
        Order obj = orderService.findById(id);
        return ResponseEntity.ok().body(obj);

    }

}
