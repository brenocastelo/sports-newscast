package com.sports.service;

import com.sports.model.News;
import com.sports.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class NewsService {

    @Autowired
    private NewsRepository newsRepository;

    @Autowired
    private UserService userService;

    public void postNews(News news) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDate newsDate = LocalDate.now();
        news.setNewsDate(newsDate);
        news.setUser(userService.getUserLoggedIn());

        newsRepository.save(news);
    }

    public List<News> getAllNews(){
        return newsRepository.findAll();
    }

    public List<News> getTop3News(){
        return newsRepository.findTop3ByOrderByNewsDateDesc();
    }

}
