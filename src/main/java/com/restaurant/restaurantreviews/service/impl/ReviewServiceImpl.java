package com.restaurant.restaurantreviews.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.restaurant.restaurantreviews.exception.ResourceNotFoundException;
import com.restaurant.restaurantreviews.model.Restaurant;
import com.restaurant.restaurantreviews.model.Review;
import com.restaurant.restaurantreviews.model.User;
import com.restaurant.restaurantreviews.repository.RestaurantRepository;
import com.restaurant.restaurantreviews.repository.ReviewRepository;
import com.restaurant.restaurantreviews.repository.UserRepository;
import com.restaurant.restaurantreviews.service.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService{

    private ReviewRepository reviewRepository;
    
    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public Review saveReview(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public List<Review> getReviews() {
        return reviewRepository.findAll();
    }
    
}
