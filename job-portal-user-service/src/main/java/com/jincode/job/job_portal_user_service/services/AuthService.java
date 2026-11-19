package com.jincode.job.job_portal_user_service.services;

public class AuthService {
    AuthResponse signup(SignupRequest req);

    AuthResponse login(LoginRequest req);
}
