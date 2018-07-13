package com.sports.controller;

import com.sports.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HomeController {

	@Autowired
	private CategoryService categoryService;

	@GetMapping
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("categories", categoryService.getAll());

		return mv;
	}

}
