package com.example.jobtracker.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.jobtracker.entity.ApplicationStatus;
import com.example.jobtracker.entity.JobApplication;

public interface JobApplicationService {

    List<JobApplication> getAll();

    List<JobApplication> getByStatus(ApplicationStatus status);

    Page<JobApplication> search(String keyword, int page, int size);

    JobApplication getById(Long id);

    JobApplication save(JobApplication app);

    void delete(Long id);

    long countAll();
}
