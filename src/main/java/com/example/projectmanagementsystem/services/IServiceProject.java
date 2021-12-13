package com.example.projectmanagementsystem.services;

import com.example.projectmanagementsystem.entities.Project;

import java.util.List;

public interface IServiceProject {
    public void addProject(Project project);
    public List<Project> getProjectsByUser(int userId);
}
