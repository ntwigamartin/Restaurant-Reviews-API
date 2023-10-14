package com.restaurant.restaurantreviews.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restaurant.restaurantreviews.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
    
}
