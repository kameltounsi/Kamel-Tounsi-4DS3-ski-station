package com.esprit.kameltounsi4ds3.Controllers;

import com.esprit.kameltounsi4ds3.entities.Color;
import com.esprit.kameltounsi4ds3.entities.Piste;
import com.esprit.kameltounsi4ds3.entities.Skier;
import com.esprit.kameltounsi4ds3.entities.TypeSubscription;
import com.esprit.kameltounsi4ds3.services.ISkierServices;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("skier")
@AllArgsConstructor
public class SkierController {
    private ISkierServices skierServices;
    @PostMapping("add")
    public Skier addSkier(@RequestBody Skier skier) {
        return skierServices.addSkier(skier);
    }
    @GetMapping("all")
    public List<Skier> retrieveAll() {
        return skierServices.retrieveAll();
    }

    @PutMapping("update")
    public Skier updateSkier(@RequestBody Skier skier)
    {
        return skierServices.updateSkier(skier);
    }
    @GetMapping("get/{numSkier}")
    public Skier retrieveSkier(@PathVariable Long numSkier) {
        return skierServices.retrieveSkier(numSkier);
    }
    @GetMapping("delete/{numSkier}")
    public void removeSkier(@PathVariable Long numSkier)
    {
        skierServices.removeSkier(numSkier);
    }
    @PutMapping("assignToPiste/{numSkier}/{numPiste}")
    public Skier assignSkierToPiste(@PathVariable Long numSkier, @PathVariable Long numPiste) {
        return skierServices.assignSkierToPiste(numSkier, numPiste);
    }

    @GetMapping("bySubscriptionType/{type}")
    public List<Skier> retrieveSkiersBySubscriptionType(@PathVariable TypeSubscription type) {
        return skierServices.retrieveSkiersBySubscriptionType(type);
    }

}
