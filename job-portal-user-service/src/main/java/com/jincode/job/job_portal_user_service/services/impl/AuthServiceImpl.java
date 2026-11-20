package com.jincode.job.job_portal_user_service.services.impl;

import org.springframework.stereotype.Service;

import com.jincode.job.job_portal_user_service.model.User;
import com.jincode.job.job_portal_user_service.payload.AuthResponse;
import com.jincode.job.job_portal_user_service.payload.LoginRequest;
import com.jincode.job.job_portal_user_service.payload.SignupRequest;
import com.jincode.job.job_portal_user_service.repository.UserRepository;
import com.jincode.job.job_portal_user_service.services.AuthService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepo;

    @Override
    public AuthResponse signup(SignupRequest req) {
        // TODO Auto-generated method stub
        User user = new User();
        return null;
    }

    @Override
    public AuthResponse login(LoginRequest req) {
        // TODO Auto-generated method stub
        var user = userRepo.findByEmail(req.getEmail());
        return null;
    }

}
