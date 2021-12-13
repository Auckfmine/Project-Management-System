package com.example.projectmanagementsystem.services;

import com.example.projectmanagementsystem.repository.SprintRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class SprintServiceImpl implements IServiceSprint{

    @Autowired
    SprintRepository sprintRepository;

    @Override
    public String retrieveSprints() {

        return null;
    }
}
