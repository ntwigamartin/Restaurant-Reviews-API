package com.restaurant.restaurantreviews.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.restaurant.restaurantreviews.exception.ResourceNotFoundException;
import com.restaurant.restaurantreviews.model.Review;
import com.restaurant.restaurantreviews.repository.ReviewRepository;
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

    @Override
    public Review getReviewById(Long reviewId) {
        return reviewRepository.findById(reviewId)
        .orElseThrow(()-> new ResourceNotFoundException("Review", reviewId));
    }
    
}
