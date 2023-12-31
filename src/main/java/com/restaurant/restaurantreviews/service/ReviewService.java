package com.restaurant.restaurantreviews.service;

import java.util.List;

import com.restaurant.restaurantreviews.model.Review;

public interface ReviewService {
    Review saveReview(Review review);
    List<Review> getReviews();
    Review getReviewById(Long reviewId);
    Review updateReview(Long reviewId, Review review);
    void deleteReview(Long reviewId);
}
