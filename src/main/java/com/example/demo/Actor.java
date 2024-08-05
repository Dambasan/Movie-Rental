package com.example.demo;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "actor")
public class Actor {

    @Id
    @Column
    @GeneratedValue
    private long id;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private String gender;

    @Column
    private String bDate;

    @Column
    private String bio;

    @Column
    private int age;

    @ManyToMany(mappedBy = "actors")
    private List<Movie> movies;

    @Column
    private String image;

    public Actor(String name, String surname, String gender, String bDate, String bio, int age, String image) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.bDate = bDate;
        this.bio = bio;
        this.age = age;
        this.image = image;
    }

    public Actor() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getbDate() {
        return bDate;
    }

    public void setbDate(String bDate) {
        this.bDate = bDate;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
}
