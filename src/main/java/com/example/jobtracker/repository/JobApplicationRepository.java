package com.example.jobtracker.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jobtracker.entity.ApplicationStatus;
import com.example.jobtracker.entity.JobApplication;

public interface JobApplicationRepository
        extends JpaRepository<JobApplication, Long> {

    List<JobApplication> findByStatus(ApplicationStatus status);

    Page<JobApplication>
    findByCompanyNameContainingIgnoreCaseOrJobRoleContainingIgnoreCase(
            String companyName,
            String jobRole,
            Pageable pageable);
}
