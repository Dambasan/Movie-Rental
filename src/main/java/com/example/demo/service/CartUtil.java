package com.example.demo.service;

import com.example.demo.models.CartEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CartUtil {

    @Autowired
    private CartService cartService;

    public int getCartCount() {
        CartEntity cart = cartService.getCart();
        if(cart == null) {
            return 0;
        }
        return cartService.getCart().getQuantity();
    }
}
