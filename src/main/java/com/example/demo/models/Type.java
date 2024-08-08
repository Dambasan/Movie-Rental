package com.example.demo.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Type")
public class Type {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String movieType;

    @OneToMany(mappedBy = "type", cascade = CascadeType.REMOVE)
    private List<Movie> movies;

    public Type(String movieType) {
        this.movieType = movieType;
    }
    public Type() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMovieType() {
        return movieType;
    }

    public void setMovieType(String movieType) {
        this.movieType = movieType;
    }
}
