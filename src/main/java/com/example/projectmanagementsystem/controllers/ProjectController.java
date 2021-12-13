package com.example.projectmanagementsystem.controllers;

import com.example.projectmanagementsystem.entities.Project;
import com.example.projectmanagementsystem.services.IServiceProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {
    @Autowired
    IServiceProject serviceProject;


    @PostMapping("/add-project")
    @ResponseBody
    public void addProject(@RequestBody Project project){
        serviceProject.addProject(project);

    }

    //http://localhost:8089/project/getProjectsByUser/{userId}
    @GetMapping("/getProjectsByUser/{userId}")
    @ResponseBody
    public List<Project> getProductsByUser(@PathVariable("userId")int userId){
        return serviceProject.getProjectsByUser(userId);
    }

}
