package com.jincode.job.job_portal_user_service.payload;

import com.jincode.job.domain.UserRole;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SignupRequest {
    @NotBlank(message = "fullname is mandatory")
    private String fullName;

    @Email(message = "email invalid")
    @NotBlank(message = "email is mandatory")
    private String email;

    @NotBlank(message = "password is mandatory")
    private String password;

    private String phone;

    @NotNull(message = "role is mandatory")
    private UserRole role;

}
