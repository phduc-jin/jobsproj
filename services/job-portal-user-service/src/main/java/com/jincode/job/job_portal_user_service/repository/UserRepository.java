package com.jincode.job.job_portal_user_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jincode.job.job_portal_user_service.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

    boolean existsByEmail(String email);
}
