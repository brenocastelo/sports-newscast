package com.sports.repository;

import com.sports.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import com.sports.model.Role;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByRole(String role);
    List<Role> findByUsersIn(User user);
	
}
