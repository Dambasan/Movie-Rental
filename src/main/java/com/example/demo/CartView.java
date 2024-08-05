package com.example.demo;

public class CartView {
    private Movie movie;
    private Integer quantity;

    public CartView() {}

    public CartView(Movie movie, Integer quantity) {
        this.movie = movie;
        this.quantity = quantity;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
