package com.jincode.job.job_portal_user_service.services;

import com.jincode.job.job_portal_user_service.payload.AuthResponse;
import com.jincode.job.job_portal_user_service.payload.LoginRequest;
import com.jincode.job.job_portal_user_service.payload.SignupRequest;

public interface AuthService {
    AuthResponse signup(SignupRequest req);

    AuthResponse login(LoginRequest req);
}
