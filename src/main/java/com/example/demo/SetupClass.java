package com.example.demo;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SetupClass {

    @Autowired
    private MovieService movieService;

    @PostConstruct
    public void init() {
        movieService.createMovie(new Movie("Esaretin Bedeli", "2000"));
        movieService.createMovie(new Movie("Harry Potter", "2000"));
        movieService.createMovie(new Movie("Inception", "2012"));
        movieService.createMovie(new Movie("Testere", "2012"));
        movieService.createMovie(new Movie("Fast and Furious", "2010"));
    }
}
