package com.example.JobPortal.repository;

import com.example.JobPortal.entity.JobPostActivity;
import com.example.JobPortal.entity.JobSeekerProfile;
import com.example.JobPortal.entity.JobSeekerSave;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobSeekerSaveRepository extends JpaRepository<JobSeekerSave, Integer> {

    public List<JobSeekerSave> findByUserId(JobSeekerProfile userAccountId);

    List<JobSeekerSave> findByJob(JobPostActivity job);

}
