package com.example.demo.controller;

import com.example.demo.*;
import com.example.demo.models.*;
import com.example.demo.service.CartService;
import com.example.demo.service.MovieService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cart")
public class ShoppingCartController {
    @Autowired
    private MovieService movieService;
    @Autowired
    private HttpSession httpSession;
    @Autowired
    private CartService cartService;

    private CartView cartView;

    public int getQuantity(HttpSession session) {
        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
        if (cart != null) {
            int total = 0;
            for (int i = 0; i < cart.getItems().size(); i++) {
                total += cart.getItems().get(i).getQuantity();
            }
            return total;
        }
        return 0;
    }

    @PostMapping
    public void addCart(@ModelAttribute MovieCart movie, HttpServletRequest request, HttpServletResponse response) throws IOException {
        cartService.addItem(movie.getMovieId(), movie.getQuantity());
        String referer = request.getHeader(HttpHeaders.REFERER);
        response.sendRedirect(referer);
    }

    @GetMapping
    public String getCart(Model model) {
        CartEntity cart = cartService.getCart();
        List<CartView> moviesCart = new ArrayList<>();
        if (cart != null) {
            for (CartItemEntity cartItem : cart.getCardItemEntities()) {
                Movie movie = movieService.getMovieById(cartItem.getMovieId());
                double totalPrice = movie.getPrice() * cartItem.getQuantity();
                CartView cartView = new CartView(movie, cartItem.getQuantity());
                moviesCart.add(cartView);
            }
            model.addAttribute("total", getTotalCardPrice(cart));
        }
        model.addAttribute("moviesCart", moviesCart);
        return "Cart";
    }

    @PostMapping("/increment")
    public String incrementCart(Long id) {
        cartService.addItem(id, 1);
        return "redirect:/cart";
    }

    @PostMapping("/decrement")
    public String decrementCart(Long id) {
        cartService.addItem(id, -1);
        return "redirect:/cart";
    }

    public double getTotalCardPrice(CartEntity cart) {
        double totalPrice = 0.0;
        for (CartItemEntity item : cart.getCardItemEntities()) {
            Movie movie = movieService.getMovieById(item.getMovieId());
            totalPrice += item.getQuantity() * movie.getPrice();
        }
        return totalPrice;
    }

    @RequestMapping("/remove")
    public String removeItem(Long id) {
        cartService.removeItem(id);
        return "redirect:/cart";
    }
}