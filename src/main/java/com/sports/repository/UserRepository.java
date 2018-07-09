package com.sports.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sports.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);
	
}
