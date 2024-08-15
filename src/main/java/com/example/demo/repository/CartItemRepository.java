package com.example.demo.repository;

import com.example.demo.models.CartEntity;
import com.example.demo.models.CartItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepository extends JpaRepository<CartItemEntity, Long> {
    CartItemEntity findByMovieId(Long movieId);
}
