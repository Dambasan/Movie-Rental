package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<CardItem> items;

    public List<CardItem> getItems() {
        if(this.items == null) {
            this.items = new ArrayList<>();
        }
        return items;
    }

    public void setItems(List<CardItem> items) {
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

    public CardItem getItem(Long id) {
        for (int i = 0; i < getItems().size(); i++) {
            if(getItems().get(i).getMovieId().equals(id)) {
                return getItems().get(i);
            }
        }
        return null;
    }
}
