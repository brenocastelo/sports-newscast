package com.sports.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sports.model.User;
import com.sports.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;

	@GetMapping("/new")
	public ModelAndView registerForm(User user) {
		ModelAndView mv = new ModelAndView("user/reader-register");
		mv.addObject("user", user);

		return mv;
	}

	@PostMapping("/new")
	public String register(User user) {

		userService.saveUser(user);
		
		return "redirect:/";
	}

}
