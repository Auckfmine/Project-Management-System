package com.example.projectmanagementsystem.repository;

import com.example.projectmanagementsystem.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {
}
