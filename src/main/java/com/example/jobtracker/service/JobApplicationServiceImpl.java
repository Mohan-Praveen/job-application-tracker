package com.example.jobtracker.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.jobtracker.entity.ApplicationStatus;
import com.example.jobtracker.entity.JobApplication;
import com.example.jobtracker.repository.JobApplicationRepository;

@Service
public class JobApplicationServiceImpl implements JobApplicationService {

    private final JobApplicationRepository repository;

    public JobApplicationServiceImpl(JobApplicationRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<JobApplication> getAll() {
        return repository.findAll();
    }

    @Override
    public List<JobApplication> getByStatus(ApplicationStatus status) {
        return repository.findByStatus(status);
    }

    @Override
    public Page<JobApplication> search(String keyword, int page, int size) {
        return repository
                .findByCompanyNameContainingIgnoreCaseOrJobRoleContainingIgnoreCase(
                        keyword, keyword, PageRequest.of(page, size));
    }

    @Override
    public JobApplication getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Job application not found"));
    }

    @Override
    public JobApplication save(JobApplication app) {
        return repository.save(app);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public long countAll() {
        return repository.count();
    }
}
