package com.github.course.repositories;

import com.github.course.entities.Order;
import com.github.course.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
