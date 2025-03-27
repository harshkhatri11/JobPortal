package com.example.JobPortal.repository;

import com.example.JobPortal.entity.JobSeekerApply;
import com.example.JobPortal.entity.JobSeekerProfile;
import com.example.JobPortal.entity.JobPostActivity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobSeekerApplyRepository extends JpaRepository<JobSeekerApply, Integer> {

    List<JobSeekerApply> findByUserId(JobSeekerProfile userId);

    List<JobSeekerApply> findByJob(JobPostActivity job);
}
