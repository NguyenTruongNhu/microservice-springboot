package com.ntndev.microservicespringboot.service;

import com.ntndev.microservicespringboot.entities.Company;

import java.util.List;

public interface CompanyService {
     List<Company> getAllCompanies();
     Company getCompanyById(Long id);
     void createCompany(Company company);
     Boolean updateCompany(Company company, Long id);
     boolean deleteCompanyById(Long id);
}
