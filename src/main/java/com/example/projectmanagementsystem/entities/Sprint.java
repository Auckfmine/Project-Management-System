package com.example.projectmanagementsystem.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "sprint")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Slf4j
public class Sprint implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int id;

    private String description;
    private Date startDate;
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)

    private Project project;
}
