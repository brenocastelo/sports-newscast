package com.sports.service;

import com.sports.model.Category;
import com.sports.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public void saveCategory(Category category) {
        categoryRepository.save(category);
    }

    public List<Category> getAll(){
        return categoryRepository.findAll();
    }

}
