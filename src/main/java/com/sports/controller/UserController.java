package com.sports.controller;



import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sports.model.Role;
import com.sports.model.User;
import com.sports.repository.RoleRepository;
import com.sports.repository.UserRepository;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;

	@GetMapping("/new")
	public ModelAndView registerForm(User user) {
		ModelAndView mv = new ModelAndView("user/reader-register");
		mv.addObject("user", user);
		mv.addObject("role", roleRepository.findAll());

		return mv;
	}

	@PostMapping("/new")
	public String register(User user) {
		Role useRole = roleRepository.findByRole("READER"); 
		user.setRoles(new ArrayList<Role>(Arrays.asList(useRole)));
		
		userRepository.save(user);

		return "redirect:/";
	}

}
