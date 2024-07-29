package com.example.demo;

import jakarta.persistence.*;

@Entity
@Table(name = "Movies")
public class Movie {
    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false, length = 50)
    private String movieName;

    @Column(nullable = false, length = 20)
    private String releaseDate;

    public Movie(String movieName, String releaseDate) {
        this.movieName = movieName;
        this.releaseDate = releaseDate;
    }

    public Movie() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
}
