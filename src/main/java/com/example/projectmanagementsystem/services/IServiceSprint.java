package com.example.projectmanagementsystem.services;

import org.springframework.scheduling.annotation.Scheduled;

public interface IServiceSprint {
    @Scheduled(fixedRate = 30000)
    public String retrieveSprints();
}
