package com.jincode.job.dto.response;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class UserResponse {
    private Long id;
    private String fullName;
    private String email;
    private String phone;
    private String profileImage;
    private String Role;
    private String Status;
    private Boolean verified;
    private LocalDateTime lastLogin;
    private LocalDateTime createAt;
}
