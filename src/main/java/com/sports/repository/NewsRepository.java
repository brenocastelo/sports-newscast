package com.sports.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sports.model.News;

public interface NewsRepository extends JpaRepository<News, Long>{

}
