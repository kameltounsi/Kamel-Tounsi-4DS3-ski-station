package com.esprit.kameltounsi4ds3.services;

import com.esprit.kameltounsi4ds3.entities.Color;
import com.esprit.kameltounsi4ds3.entities.Piste;
import com.esprit.kameltounsi4ds3.Repositories.IPisteRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.ClientInfoStatus;
import java.util.List;
@Service
@AllArgsConstructor
public class PistesServicesImpl implements IPisteServices{

private  IPisteRepository pisteRepository;
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
}
