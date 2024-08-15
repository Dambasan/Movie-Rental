package com.example.demo.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="CartEntity")

public class CartEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private Integer quantity;



    @OneToMany(mappedBy = "cartEntity", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<CartItemEntity> cardItemEntities = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "users_id", referencedColumnName = "id")
    private User user;

    public CartEntity(long id, List<CartItemEntity> cardItemEntities, User user) {
        this.id = id;
        this.cardItemEntities = cardItemEntities;
        this.user = user;
    }

    public CartEntity() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<CartItemEntity> getCardItemEntities() {
        return cardItemEntities;
    }

    public void setCardItemEntities(List<CartItemEntity> cardItemEntities) {
        this.cardItemEntities = cardItemEntities;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getQuantity() {
        return quantity == null ? 0 : quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
