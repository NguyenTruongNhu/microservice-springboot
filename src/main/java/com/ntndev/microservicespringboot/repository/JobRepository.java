package com.ntndev.microservicespringboot.repository;


import com.ntndev.microservicespringboot.entities.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface JobRepository extends JpaRepository<Job, Long> {

}
