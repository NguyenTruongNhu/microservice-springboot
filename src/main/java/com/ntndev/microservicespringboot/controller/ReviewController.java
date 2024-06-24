package com.ntndev.microservicespringboot.controller;

import com.ntndev.microservicespringboot.entities.Review;
import com.ntndev.microservicespringboot.service.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController {

    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getAllReviews(@PathVariable Long companyId) {
        return ResponseEntity.ok(reviewService.getAllReviews(companyId));
    }

    @PostMapping("/reviews")
    public ResponseEntity<String> addReview(@PathVariable Long companyId, @RequestBody Review review) {
      boolean isReviewSaved =   reviewService.addReview(companyId, review);
        if(!isReviewSaved) {
            return ResponseEntity.badRequest().body("Company not found");
        }
        return ResponseEntity.ok("Review added successfully");
    }

    @GetMapping("/reviews/{reviewId}")
    public ResponseEntity<Review> getReview(@PathVariable Long companyId, @PathVariable Long reviewId) {
        Review review = reviewService.getReview(companyId, reviewId);
        if(review == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(review);
    }

    @PutMapping("/reviews/{reviewId}")
    public ResponseEntity<String> updateReview(@PathVariable Long companyId, @PathVariable Long reviewId, @RequestBody Review review) {
        boolean isReviewUpdated = reviewService.updateReview(companyId, reviewId, review);
        if(!isReviewUpdated) {
            return ResponseEntity.badRequest().body("Company not found");
        }
        return ResponseEntity.ok("Review updated successfully");
    }

    @DeleteMapping("/reviews/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable Long companyId, @PathVariable Long reviewId) {
        boolean isReviewDeleted = reviewService.deleteReview(companyId, reviewId);
        if(!isReviewDeleted) {
            return ResponseEntity.badRequest().body("Company not found");
        }
        return ResponseEntity.ok("Review deleted successfully");
    }



}
