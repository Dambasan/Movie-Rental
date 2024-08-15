package com.example.demo.service;

import com.example.demo.MyUserPrincipal;
import com.example.demo.models.CartEntity;
import com.example.demo.models.CartItemEntity;
import com.example.demo.models.Movie;
import com.example.demo.repository.CartItemRepository;
import com.example.demo.repository.CartRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private CartItemRepository cartItemRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MovieService movieService;

    public CartEntity getCart() {
        String username = ((MyUserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
        return getCart(username);
    }

    public CartEntity getCart(String username) {
        return cartRepository.findByUserEmail(username);
    }

    public void setCount(CartEntity cart) {
        if(cart != null) {
            int count = 0;
            for (CartItemEntity cardItemEntity : cart.getCardItemEntities()) {
                count += cardItemEntity.getQuantity();
            }
            cart.setQuantity(count);
            cartRepository.save(cart);
        }
    }

    public void removeItem(Long movieId) {
        CartItemEntity cartItemEntity = cartItemRepository.findByMovieId(movieId);
        if(null != cartItemEntity) {
            cartItemRepository.delete(cartItemEntity);
            setCount(getCart());
        }
    }

    public CartEntity addItem(Long movieId, Integer quantity) {
        String username = ((MyUserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
        CartEntity cart = cartRepository.findByUserEmail(username);
        if (cart == null) {
            cart = new CartEntity();
            cart.setUser(userRepository.findByEmail(username));
        }
        CartItemEntity itemEntity = cart.getCardItemEntities().stream().filter(i -> i.getMovieId().equals(movieId)).findFirst().orElse(null);
        boolean itemInCart = false;
        if (itemEntity != null) {
            itemInCart = true;
            itemEntity.setQuantity(itemEntity.getQuantity() + quantity);
        } else {
            itemEntity = new CartItemEntity();
            itemEntity.setMovieId(movieId);
            itemEntity.setQuantity(quantity);
            itemEntity.setCartEntity(cart);
        }
        Movie movie = movieService.getMovieById(movieId);
        if (movie.getStok() < itemEntity.getQuantity()) {
            throw new RuntimeException("Yeterli stok bulunamadı");
        }
        if (itemEntity.getQuantity() <= 0 && itemInCart) {
            cart.setCardItemEntities(cart.getCardItemEntities().stream().filter(i -> !i.getMovieId().equals(movieId)).collect(Collectors.toList()));
            cartItemRepository.delete(itemEntity);
            setCount(cart);
            return cart;
        }
        if(!itemInCart) {
            cart.getCardItemEntities().add(itemEntity);
        }
        setCount(cart);
        return cartRepository.save(cart);
    }
}
