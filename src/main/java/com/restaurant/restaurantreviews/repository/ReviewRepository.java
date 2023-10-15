package com.restaurant.restaurantreviews.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restaurant.restaurantreviews.model.Review;

public interface ReviewRepository extends JpaRepository<Review, Long>{
    
}
