package com.ntndev.microservicespringboot.service;

import com.ntndev.microservicespringboot.entities.Job;

import java.util.List;

public interface JobService {
    List<Job> findAll();

    void createJob(Job  job);

    Job getJobById(Long id);
    boolean deleteJobById(Long id);

    boolean updateJobById(Long id, Job updateJob);
}