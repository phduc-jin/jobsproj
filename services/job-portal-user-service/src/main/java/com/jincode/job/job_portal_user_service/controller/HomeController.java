package com.jincode.job.job_portal_user_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.jincode.job.domain.UserRole;

@RestController
public class HomeController {
    @GetMapping
    public String Home() {
        return "hello" + UserRole.ROLE_EMPLOYER;
    }
}
