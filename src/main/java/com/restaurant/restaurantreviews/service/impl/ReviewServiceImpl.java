package com.restaurant.restaurantreviews.service.impl;

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
    private RestaurantRepository restaurantRepository;
    private UserRepository userRepository;
    
    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public Review saveReview(Review review) {
        // Review newReview = new Review();
        // Restaurant restaurant = restaurantRepository.findById(restaurantId)
        // .orElseThrow(()-> new ResourceNotFoundException("Restaurant", restaurantId));

        // User user = userRepository.findById(userId)
        // .orElseThrow(()-> new ResourceNotFoundException("User", userId));
        // newReview.setComment(comment);
        // newReview.setRestaurant(restaurant);
        // newReview.setUser(user);
        // System.out.println(review);
        return reviewRepository.save(review);
    }
    
}
