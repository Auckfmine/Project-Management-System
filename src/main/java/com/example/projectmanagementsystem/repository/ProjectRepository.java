package com.example.projectmanagementsystem.repository;

import com.example.projectmanagementsystem.entities.Project;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProjectRepository extends CrudRepository<Project,Integer> {


}
