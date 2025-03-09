package com.esprit.kameltounsi4ds3.services;

import com.esprit.kameltounsi4ds3.entities.Color;
import com.esprit.kameltounsi4ds3.entities.Piste;
import com.esprit.kameltounsi4ds3.entities.Skier;

import java.util.List;

public interface ISkierServices {
    Skier addSkier(Skier skier);
    Skier updateSkier(Skier skier);
    Skier retrieveSkier(Long numSkier);
    void removeSkier(Long numSkier);
    List<Skier> retrieveAll();
}
