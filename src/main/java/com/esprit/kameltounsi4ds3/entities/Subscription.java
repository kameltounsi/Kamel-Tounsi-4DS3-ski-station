package com.esprit.kameltounsi4ds3.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Data
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numSub;

    private LocalDate startDate;
    private LocalDate endDate;
    private float price;

    @Enumerated(EnumType.STRING)
    private TypeSubscription typeSub;
}

