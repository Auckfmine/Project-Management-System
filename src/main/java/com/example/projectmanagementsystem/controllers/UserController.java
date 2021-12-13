package com.example.projectmanagementsystem.controllers;

import com.example.projectmanagementsystem.entities.User;
import com.example.projectmanagementsystem.services.IServiceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    IServiceUser serviceUser;
    //http://localhost:8089/api/user/add-user
    @PostMapping("/add-user")
    @ResponseBody
    public void addUser(@RequestBody User user){
        System.out.println(user);
        serviceUser.addUser(user);
    }

    //http://localhost:8089/api/user/assignProjectToUser

    @GetMapping("/assignProjectToUser/{projectId}/{userId}")
    @ResponseBody

    public void assignProjectToUser(@PathVariable("projectId") int projectId , @PathVariable("userId")int userId){
        serviceUser.assignProjectToUser(projectId,userId);
    }
}
