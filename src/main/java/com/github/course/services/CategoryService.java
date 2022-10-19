package com.github.course.services;


import com.github.course.entities.Category;
import com.github.course.repositories.CategoryRepository;
import com.github.course.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public List<Category> findAll(){
        return categoryRepository.findAll();
    }

    public Category findById(Long id){
        Optional<Category> byId = categoryRepository.findById(id);
        return byId.get();
    }
}
