package com.jincode.job.job_portal_user_service.services.impl;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.jincode.job.domain.UserRole;
import com.jincode.job.job_portal_user_service.mapper.UserMapper;
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
    public AuthResponse signup(SignupRequest req) throws Exception {
        if (userRepo.existsByEmail(req.getEmail())) {
            throw new Exception("email already registerd: " + req.getEmail());
        }

        if (req.getRole() == UserRole.ROLE_ADMIN) {
            throw new Exception("can't self-register as admin");
        }
        User user = User.builder()
                .fullName(req.getFullName())
                .email(req.getEmail())
                .role(req.getRole())
                .phone(req.getPhone())
                .password(req.getPassword())
                .lastLogin(LocalDateTime.now())
                .build();
        var savedUser = userRepo.save(user);
        var resp = new AuthResponse();
        resp.setTitle("welcom " + savedUser.getFullName());
        resp.setMessage("register successfully");
        resp.setJwt("jwt");

        var userResp = UserMapper.toDTO(savedUser);
        resp.setUser(userResp);
        return resp;
    }

    @Override
    public AuthResponse login(LoginRequest req) {
        // TODO Auto-generated method stub
        var user = userRepo.findByEmail(req.getEmail());
        return null;
    }

}
