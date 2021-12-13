package com.example.projectmanagementsystem.services;

import com.example.projectmanagementsystem.entities.Project;
import com.example.projectmanagementsystem.entities.Sprint;
import com.example.projectmanagementsystem.entities.User;
import com.example.projectmanagementsystem.repository.ProjectRepository;
import com.example.projectmanagementsystem.repository.SprintRepository;
import com.example.projectmanagementsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceProjectImpl implements IServiceProject{
    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    SprintRepository sprintRepository;

    @Autowired
    UserRepository userRepository;


    @Override

    public void addProject(Project project) {
        Sprint sprint = project.getSprints().stream().findFirst().orElse(null);

        sprint.setProject(project);
        sprintRepository.save(sprint);
        projectRepository.save(project);

    }

    @Override
    public List<Project> getProjectsByUser(int userId) {
        List<Project> projects = new ArrayList<Project>();
        User user =userRepository.findById(userId).orElse(null);
        user.getProjects().forEach( project->{
            projects.add(project);
        });

        return projects;
    }
}
