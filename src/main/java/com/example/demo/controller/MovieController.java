package com.example.demo.controller;

import com.example.demo.models.Movie;
import com.example.demo.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping
    public String getAllMovies(Model model, @RequestParam(value = "type", required = false) Long type) {
        model.addAttribute("movies", movieService.getAllMovies(type));
        return "movies";
    }

    @GetMapping("/{id}")
    public String getMovie(@PathVariable Long id, Model model) {
        model.addAttribute("movie", movieService.getMovieById(id));
        return "movie";
    }

    @GetMapping("/new-movie")
    public String movieSaveForm(Model model) {
        model.addAttribute("movie", new Movie());
        model.addAttribute("action", "/movies");
        return "new-movie";
    }

    @PostMapping
    public String movieSubmit(@ModelAttribute Movie movie, Model model) {
        movieService.createMovie(movie);
        return "redirect:/movies";
    }

    @RequestMapping(value = "/delete-movie", method = RequestMethod.GET)
    private String deleteMovie(@RequestParam Long id) {
        movieService.deleteMovie(id);
        return "redirect:/movies";
    }

    @RequestMapping(value = "/update-movie", method = RequestMethod.GET)
    private String updateMovie(@RequestParam Long id, Model model) {
        Movie movie = movieService.getMovieById(id);
        model.addAttribute("movie", movie);
        model.addAttribute("action", "/movies/update-movie?id=" + id);
        return "new-movie";
    }

    @RequestMapping(value = "/update-movie", method = RequestMethod.POST)
    private String updateMoviePost(@RequestParam Long id, @ModelAttribute Movie movie) {
        movieService.updateMovie(movie, id);
        return "redirect:/movies";
    }

}
