package com.esprit.kameltounsi4ds3.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numCourse;

    private int level;

    @Enumerated(EnumType.STRING)
    private TypeCourse typeCourse;

    @Enumerated(EnumType.STRING)
    private Support support;

    private float price;
    private int timeSlot;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "course")
    private Set<Registration> registrations;
}
