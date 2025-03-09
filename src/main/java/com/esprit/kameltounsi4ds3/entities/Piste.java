package com.esprit.kameltounsi4ds3.entities;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
public class Piste {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numPiste;

    private String namePiste;

    @Enumerated(EnumType.STRING)
    private Color color;

    private int length;
    private int slope;
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Skier> skier;

}

