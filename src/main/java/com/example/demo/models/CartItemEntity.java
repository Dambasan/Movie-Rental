package com.example.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name="CartItemEntity")
public class CartItemEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private Long movieId;

    @Column
    private int quantity;

    @ManyToOne
    @JoinColumn(name="cartEntity_id", nullable=false)
    private CartEntity cartEntity;

    public CartItemEntity(long id, long movieId, int quantity, CartEntity cartEntity) {
        this.id = id;
        this.movieId = movieId;
        this.quantity = quantity;
        this.cartEntity = cartEntity;
    }
    public CartItemEntity() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public CartEntity getCartEntity() {
        return cartEntity;
    }

    public void setCartEntity(CartEntity cartEntity) {
        this.cartEntity = cartEntity;
    }
}
