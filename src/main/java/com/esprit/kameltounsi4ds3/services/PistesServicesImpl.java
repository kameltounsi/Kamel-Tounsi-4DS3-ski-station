package com.esprit.kameltounsi4ds3.services;

import com.esprit.kameltounsi4ds3.Repositories.ISkierRepository;
import com.esprit.kameltounsi4ds3.entities.Color;
import com.esprit.kameltounsi4ds3.entities.Piste;
import com.esprit.kameltounsi4ds3.Repositories.IPisteRepository;
import com.esprit.kameltounsi4ds3.entities.Skier;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class PistesServicesImpl implements IPisteServices{

private  IPisteRepository pisteRepository;
    private ISkierRepository skierRepository; // Inject the SkierRepository
    @Override
    public Piste addPiste(Piste piste) {
     //Traitement et controle de saisi
        return pisteRepository.save(piste);
    }

    @Override
    public Piste updatePiste(Piste piste) {
        return pisteRepository.save(piste);
    }

    @Override
    public Piste retrievePiste(Long numPiste) {
        return pisteRepository.findById(numPiste).orElse(null);
    }

    @Override
    public void removePiste(Long numPiste) {
        pisteRepository.deleteById(numPiste);
    }

    @Override
    public List<Piste> retrieveAll() {
        return pisteRepository.findAll();
    }

    @Override
    public List<Piste> retrieveAllByColor(Color color) {
        return pisteRepository.findByColor(color);
    }

    @Override
    public Skier assignSkierToPiste(Long numSkier, Long numPiste) {
        return null;
    }

    @Override
    public Piste assignPisteToSkier(Long numPiste, Long numSkier) {
        Piste piste = pisteRepository.findById(numPiste).orElse(null);
        Skier skier = skierRepository.findById(numSkier).orElse(null);

        assert piste != null;
        piste.getSkier().add(skier);

        return pisteRepository.save(piste);
    }
}
