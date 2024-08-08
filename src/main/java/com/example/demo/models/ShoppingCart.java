package com.example.demo.models;

import com.example.demo.CartItem;
import com.example.demo.CartView;
import com.example.demo.service.MovieService;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<CartItem> items;
    private MovieService movieService;
    private CartView cartView;

    public List<CartItem> getItems() {
        if(this.items == null) {
            this.items = new ArrayList<>();
        }
        return items;
    }

    public void setItems(List<CartItem> items) {
        this.items = items;
    }

    public boolean containsItem(Long id) {
        for (int i = 0; i < getItems().size(); i++) {
            if(getItems().get(i).getMovieId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public CartItem getItem(Long id) {
        for (int i = 0; i < getItems().size(); i++) {
            if(getItems().get(i).getMovieId().equals(id)) {
                return getItems().get(i);
            }
        }
        return null;
    }
    public void removeItem(Long movieId) {
        items.removeIf(item -> item.getMovieId().equals(movieId));
    }
}
