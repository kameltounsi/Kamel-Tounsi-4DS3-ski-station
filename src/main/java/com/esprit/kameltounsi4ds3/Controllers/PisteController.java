package com.esprit.kameltounsi4ds3.Controllers;

import com.esprit.kameltounsi4ds3.entities.Color;
import com.esprit.kameltounsi4ds3.entities.Piste;
import com.esprit.kameltounsi4ds3.services.IPisteServices;
import com.esprit.kameltounsi4ds3.services.PistesServicesImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("piste")
@AllArgsConstructor
public class PisteController {
    private IPisteServices pisteservices;
    @GetMapping("all")
    public List<Piste> retrieveAll() {
        return pisteservices.retrieveAll();
    }
    @PostMapping("add")
    public Piste addPiste(@RequestBody Piste piste) {
        return pisteservices.addPiste(piste);
    }
    @PutMapping("update")
    public Piste updatePiste(@RequestBody Piste piste)
    {
        return pisteservices.updatePiste(piste);
    }
    @GetMapping("get/{numPiste}")
    public Piste retrievePiste(@PathVariable Long numPiste) {
        return pisteservices.retrievePiste(numPiste);
    }
    @GetMapping("delete/{numPiste}")
    public void removePiste(@PathVariable Long numPiste)
    {
        pisteservices.removePiste(numPiste);
    }
    @GetMapping("getByColor/{color}")
    public List<Piste> retrievePisteByColor(@PathVariable Color color) {
        return  pisteservices.retrieveAllByColor(color);
    }


}

