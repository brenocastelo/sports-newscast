package com.sports.controller;

import com.sports.model.News;
import com.sports.service.CategoryService;
import com.sports.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/post")
    public ModelAndView newsForm(News news) {
        ModelAndView mv = new ModelAndView("news/news-register");
        mv.addObject("news", news);
        mv.addObject("categories", categoryService.getAll());

        return mv;
    }

    @PostMapping("/post")
    public ModelAndView post(News news) {
        ModelAndView mv = new ModelAndView("redirect:/news/post");
        newsService.postNews(news);

        return mv;
    }

}


