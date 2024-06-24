package com.ntndev.microservicespringboot.serviceImpl;

import com.ntndev.microservicespringboot.entities.Company;
import com.ntndev.microservicespringboot.entities.Review;
import com.ntndev.microservicespringboot.repository.ReviewRepository;
import com.ntndev.microservicespringboot.service.CompanyService;
import com.ntndev.microservicespringboot.service.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;

    private final CompanyService companyService;

    public ReviewServiceImpl(ReviewRepository reviewRepository, CompanyService companyService) {
        this.reviewRepository = reviewRepository;
        this.companyService = companyService;
    }

    @Override
    public List<Review> getAllReviews(Long companyId) {
        return reviewRepository.findByCompanyId(companyId);
    }

    @Override
    public boolean addReview(Long companyId, Review review) {
        Company company = companyService.getCompanyById(companyId);
        if (company != null) {
            review.setCompany(company);
            reviewRepository.save(review);
            return true;
        }
        return false;

    }

    @Override
    public Review getReview(Long companyId, Long reviewId) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);
        return reviews.stream()
                .filter(review -> review.getId().equals(reviewId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean updateReview(Long companyId, Long reviewId, Review updateReview) {
        if (companyService.getCompanyById(companyId) != null) {
            updateReview.setCompany(companyService.getCompanyById(companyId));
            updateReview.setId(reviewId);
            reviewRepository.save(updateReview);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean deleteReview(Long companyId, Long reviewId) {

        if (companyService.getCompanyById(companyId) != null && reviewRepository.existsById(reviewId)) {
           Review review = reviewRepository.findById(reviewId).orElse(null);
           Company company = review.getCompany();
           company.getReviews().remove(review);
           review.setCompany(null);
           companyService.updateCompany(company, companyId);
           reviewRepository.deleteById(reviewId);
            return true;
        }
        return false;
    }
}
