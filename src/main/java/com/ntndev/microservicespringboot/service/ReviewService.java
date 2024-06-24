package com.ntndev.microservicespringboot.service;

import com.ntndev.microservicespringboot.entities.Review;

import java.util.List;

public interface ReviewService {

    List<Review> getAllReviews(Long companyId);
    boolean addReview(Long companyId,Review review);

    Review getReview(Long companyId, Long reviewId);

    boolean updateReview(Long companyId, Long reviewId, Review updateReview);

    boolean deleteReview(Long companyId, Long reviewId);
}
