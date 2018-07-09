package com.sports.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sports.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long>{

}
