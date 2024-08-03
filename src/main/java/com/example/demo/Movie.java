package com.example.demo;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Movies")
public class Movie {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, length = 50)
    private String movieName;

    @Column(nullable = false, length = 20)
    private String releaseDate;

    @Column
    private String coverPhoto;

    @Column(length = 2000)
    private String description;

    @ManyToOne
    @JoinColumn(name = "type", referencedColumnName = "id")
    private Type type;

    @Column
    private int stok;

    @ManyToMany
    @JoinTable(name = "movie_actor")
    private List<Actor> actors;

    public Movie(String movieName, String releaseDate, String coverPhoto, String description, Type type, int stok, List<Actor> actors) {
        this.movieName = movieName;
        this.releaseDate = releaseDate;
        this.coverPhoto = coverPhoto;
        this.description = description;
        this.type = type;
        this.stok = stok;
        this.actors = actors;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Movie() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getCoverPhoto() {
        return coverPhoto;
    }

    public void setCoverPhoto(String coverPhoto) {
        this.coverPhoto = coverPhoto;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }
}
