package com.esprit.kameltounsi4ds3.services;

import com.esprit.kameltounsi4ds3.entities.Color;
import com.esprit.kameltounsi4ds3.entities.Piste;
import com.esprit.kameltounsi4ds3.entities.Skier;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
public interface IPisteServices {
    Piste addPiste(Piste piste);
    Piste updatePiste(Piste piste);
    Piste retrievePiste(Long numPiste);
    void removePiste(Long numPiste);
    List<Piste> retrieveAll();
    List<Piste> retrieveAllByColor(Color color);
    Skier assignSkierToPiste(Long numSkier, Long numPiste);

    Piste assignPisteToSkier(Long numPiste, Long numSkier);
}
