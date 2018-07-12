package com.sports.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sports.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

	public Role findByRole(String role);
	
}
