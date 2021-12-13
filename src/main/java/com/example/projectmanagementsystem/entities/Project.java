package com.example.projectmanagementsystem.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "project")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Slf4j
public class Project implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private String description;
    @ManyToMany(fetch = FetchType.LAZY,mappedBy = "projects")
    @JsonIgnoreProperties("projects")
    private Set<User> users;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "project",cascade = CascadeType.ALL)
    @JsonIgnoreProperties("project")
    private Set<Sprint>sprints;

}
