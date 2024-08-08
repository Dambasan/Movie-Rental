package com.example.demo.service;

import com.example.demo.models.Movie;
import com.example.demo.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> getAllMovies(Long type) {
        if(type != null) {
            return movieRepository.findAllByTypeId(type);
        }
        return movieRepository.findAll();
    }
    public Movie getMovieById(Long id) {
        return movieRepository.findById(id).orElse(null);
    }
    public Movie createMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public Movie updateMovie(Movie movie, Long id) {
        Movie existingMovie = movieRepository.findById(id).orElse(null);
        if (existingMovie != null) {
            existingMovie.setMovieName(movie.getMovieName());
            existingMovie.setReleaseDate(movie.getReleaseDate());
            return movieRepository.save(existingMovie);
        }else {
            return null;
        }
    }
    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }


}
