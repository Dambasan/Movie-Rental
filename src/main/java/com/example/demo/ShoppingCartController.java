package com.example.demo;

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

    @PostMapping
    public void addCart(@ModelAttribute MovieCart movie, HttpSession session, HttpServletRequest request, HttpServletResponse response) throws IOException {
        ShoppingCart cart = new ShoppingCart();
        if(session.getAttribute("cart") != null) {
            cart = (ShoppingCart) session.getAttribute("cart");
        }
        if (cart.containsItem(movie.getMovieId())) {
            CardItem item = cart.getItem(movie.getMovieId());
            item.setQuantity(item.getQuantity() + 1);
        } else {
            CardItem cardItem = new CardItem();
            cardItem.setMovieId(movie.getMovieId());
            cardItem.setQuantity(1);
            cart.getItems().add(cardItem);
        }
        session.setAttribute("cart", cart);
        session.setAttribute("cartCount", getQuantity(session));
        String referer = request.getHeader(HttpHeaders.REFERER);
        response.sendRedirect(referer);
    }

    public int getQuantity(HttpSession session) {
        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
        if(cart != null) {
            int total = 0;
            for (int i = 0; i < cart.getItems().size(); i++) {
                total += cart.getItems().get(i).getQuantity();
            }
            return total;
        }
        return 0;
    }

    @GetMapping
    public String getCart(HttpSession session, Model model) {
        ShoppingCart cart = null;
        List<CartView> moviesCart = new ArrayList<>();
        if(session.getAttribute("cart") != null) {
            cart = (ShoppingCart) session.getAttribute("cart");
            for (int i = 0; i < cart.getItems().size(); i++) {
                CardItem cardItem = cart.getItems().get(i);
                moviesCart.add(new CartView(movieService.getMovieById(cardItem.getMovieId()), cardItem.getQuantity()));
            }
        }
        model.addAttribute("moviesCart", moviesCart);
        return "Cart";
    }
}