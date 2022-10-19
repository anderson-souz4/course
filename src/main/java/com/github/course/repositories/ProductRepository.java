package com.github.course.repositories;

import com.github.course.entities.Category;
import com.github.course.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
