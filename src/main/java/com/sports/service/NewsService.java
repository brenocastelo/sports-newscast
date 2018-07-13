package com.sports.service;

import com.sports.model.News;
import com.sports.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class NewsService {

    @Autowired
    private NewsRepository newsRepository;

    public void postNews(News news) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDate newsDate = LocalDate.now();
        news.setNewsDate(newsDate);

        newsRepository.save(news);
    }

}
