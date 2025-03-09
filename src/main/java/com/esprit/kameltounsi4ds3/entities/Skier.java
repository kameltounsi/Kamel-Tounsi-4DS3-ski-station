package com.esprit.kameltounsi4ds3.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
public class Skier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numSkier;

    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String city;
    @OneToOne
    private Subscription subscription;
    @ManyToMany(cascade = CascadeType.ALL ,  mappedBy = "skier")
    private Set<Piste> pisteSet;
@OneToMany(cascade = CascadeType.ALL, mappedBy = "skier")
    public Set<Registration> registrations;
}

