package com.example.projectmanagementsystem.services;

import com.example.projectmanagementsystem.entities.User;

public interface IServiceUser {
    public void addUser(User u);
    public void assignProjectToUser(int projectId,int userId);
}
