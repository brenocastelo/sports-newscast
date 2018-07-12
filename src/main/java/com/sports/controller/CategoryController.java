package com.sports.controller;

import com.sports.model.Category;
import com.sports.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/new")
    public ModelAndView registerForm(Category category) {
        ModelAndView mv = new ModelAndView("category/category-register");
        mv.addObject("category ", category);

        return mv;
    }

    @PostMapping("/new")
    public String register(Category category) {
        categoryService.saveCategory(category);

        return "redirect:/category/new";
    }

}
