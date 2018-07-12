package com.sports.service;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sports.model.Role;
import com.sports.model.User;
import com.sports.repository.RoleRepository;
import com.sports.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;

	public void saveUser (User user) {
		Role useRole = roleRepository.findByRole("READER"); 
		user.setRoles(new ArrayList<Role>(Arrays.asList(useRole)));
		
		userRepository.save(user);
	}
	
}
