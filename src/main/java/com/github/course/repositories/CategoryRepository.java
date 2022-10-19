package com.github.course.repositories;

import com.github.course.entities.Category;
import com.github.course.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
