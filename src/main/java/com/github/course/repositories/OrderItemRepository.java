package com.github.course.repositories;

import com.github.course.entities.OrderItem;
import com.github.course.entities.User;
import com.github.course.entities.pk.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {
}
