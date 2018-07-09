package com.sports.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sports.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
