package com.jincode.job.job_portal_user_service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jincode.job.job_portal_user_service.payload.AuthResponse;
import com.jincode.job.job_portal_user_service.payload.SignupRequest;
import com.jincode.job.job_portal_user_service.services.AuthService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping
    private ResponseEntity<AuthResponse> signup(@RequestBody @Valid SignupRequest req) throws Exception {
        return ResponseEntity.ok(authService.signup(req));
    }
}
