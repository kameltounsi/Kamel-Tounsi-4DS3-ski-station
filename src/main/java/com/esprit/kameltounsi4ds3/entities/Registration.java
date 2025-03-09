package com.esprit.kameltounsi4ds3.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numRegistration;

    private int numWeek;
    @ManyToOne(cascade = CascadeType.ALL)
    private Skier skier;
    @ManyToOne(cascade = CascadeType.ALL)
    private Course course;
}

