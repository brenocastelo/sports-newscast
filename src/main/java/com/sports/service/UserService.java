package com.sports.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

	private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	public void saveUser (User user) {
		Role useRole = roleRepository.findByRole("READER"); 
		user.setRoles(Arrays.asList(useRole));
		user.setEnabled(true);
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		userRepository.save(user);
	}

	public User getUserLoggedIn() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getName();

		return findUserByEmail(email);
	}
	
}
