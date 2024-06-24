package com.ntndev.microservicespringboot.repository;

import com.ntndev.microservicespringboot.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long>{
}
