package com.ntndev.microservicespringboot.repository;

import com.ntndev.microservicespringboot.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long>{

    List<Review> findByCompanyId(Long companyId);
}
