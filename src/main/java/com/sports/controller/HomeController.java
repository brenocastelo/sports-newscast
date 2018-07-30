package com.sports.controller;

import com.sports.model.News;
import com.sports.service.CategoryService;
import com.sports.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {

	@Autowired
	private CategoryService categoryService;

	@Autowired
    private NewsService newsService;

	@GetMapping
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("categories", categoryService.getAll());
		List<News> news = newsService.getTop3News();
		mv.addObject("news", news);
		for (News n : news) {
			System.out.println(n.getTitle());
		}

		return mv;
	}

}
