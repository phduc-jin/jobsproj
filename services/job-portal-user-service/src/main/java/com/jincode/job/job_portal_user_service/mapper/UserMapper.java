package com.jincode.job.job_portal_user_service.mapper;

import com.jincode.job.dto.response.UserResponse;
import com.jincode.job.job_portal_user_service.model.User;

public class UserMapper {
    public static UserResponse toDTO(User user) {
        var dto = new UserResponse();
        dto.setId(user.getId());
        dto.setEmail(user.getEmail());
        dto.setFullName(user.getFullName());
        dto.setPhone(user.getPhone());
        dto.setProfileImage(user.getProfileImage());
        dto.setRole(user.getRole().toString());
        dto.setStatus(user.getUserStatus().toString());
        dto.setLastLogin(user.getLastLogin());
        dto.setCreateAt(user.getCreatedAt());
        return dto;
    }
}
