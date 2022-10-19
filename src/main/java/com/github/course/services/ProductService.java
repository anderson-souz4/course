package com.github.course.services;


import com.github.course.entities.Category;
import com.github.course.entities.Product;
import com.github.course.repositories.CategoryRepository;
import com.github.course.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public Product findById(Long id){
        Optional<Product> byId = productRepository.findById(id);
        return byId.get();
    }
}
