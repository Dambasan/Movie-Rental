package com.example.demo;

public class CartView {
    private Movie movie;
    private int quantity;

    public CartView(Movie movie, int quantity) {
        this.movie = movie;
        this.quantity = quantity;
    }

    // Getters and setters
    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return movie.getPrice() * quantity;
    }
//    public double getTotalCardPrice() {
//        double totalPrice = 0.0;
//        for (CardItem item : shoppingCart.getItems()) {
//            Movie movie = movieService.getMovieById(item.getMovieId());
//            totalPrice += getTotalPrice();
//        }
//        return totalPrice;
//    }
}
