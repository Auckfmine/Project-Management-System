package com.example.projectmanagementsystem.services;

import com.example.projectmanagementsystem.entities.Project;
import com.example.projectmanagementsystem.entities.User;
import com.example.projectmanagementsystem.repository.ProjectRepository;
import com.example.projectmanagementsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceUserImpl implements IServiceUser{
    @Autowired
    UserRepository userRepository;

    @Autowired
    ProjectRepository projectRepository;

    @Override
    public void addUser(User u) {
        userRepository.save(u);
    }

    @Override
    public void assignProjectToUser(int projectId, int userId) {
        Project project = projectRepository.findById(projectId).orElse(null);
        User user = userRepository.findById(userId).orElse(null);
        assert user != null;
        user.getProjects().add(project);
        userRepository.save(user);
    }


}
