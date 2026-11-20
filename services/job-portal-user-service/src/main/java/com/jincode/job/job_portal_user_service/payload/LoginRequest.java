package com.jincode.job.job_portal_user_service.payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginRequest {
    @Email(message = "email invalid")
    @NotBlank(message = "email is manadatory")
    private String email;

    @NotBlank(message = "password is manadatory")
    private String password;
}
