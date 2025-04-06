package com.esprit.kameltounsi4ds3.services;

import com.esprit.kameltounsi4ds3.Repositories.*;
import com.esprit.kameltounsi4ds3.entities.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class SkierServicesImpl implements ISkierServices{
    private ISkierRepository skierRepository;
    private IPisteRepository pisteRepository;

    private ICourseRepository courseRepository;

    private IRegistrationRepository registrationRepository;

    private ISubscriptionRepository subscriptionRepository;
    @Override
    public Skier addSkier(Skier skier) {
        return skierRepository.save(skier);
    }

    @Override
    public Skier updateSkier(Skier skier) {
        return skierRepository.save(skier);
    }

    @Override
    public Skier retrieveSkier(Long numSkier) {
        return skierRepository.findById(numSkier).orElse(null);
    }

    @Override
    public void removeSkier(Long numSkier) {
        skierRepository.deleteById(numSkier);
    }

    @Override
    public List<Skier> retrieveAll() {
        return skierRepository.findAll();
    }

    @Override
    public Skier addSkierAndAssignToCourse(Skier skier, Long numCourse) {
        Skier savedSkier = skierRepository.save(skier);
        Course course = courseRepository.getById(numCourse);

        Set<Registration> registrations = savedSkier.getRegistrations();
        for (Registration r : registrations) {
            r.setSkier(savedSkier);
            r.setCourse(course);
            registrationRepository.save(r);
        }
        return savedSkier;
    }

    @Override
    public List<Skier> retrieveSkiersBySubscriptionType(TypeSubscription typeSubscription) {
        return skierRepository.findBySubscription_TypeSub(typeSubscription);
    }
    @Override
    public Skier assignSkierToPiste(Long numSkier, Long numPiste) {
        Skier skier = skierRepository.findById(numSkier)
                .orElseThrow(() -> new RuntimeException("Skier not found with ID: " + numSkier));
        Piste piste = pisteRepository.findById(numPiste)
                .orElseThrow(() -> new RuntimeException("Piste not found with ID: " + numPiste));
        skier.getPisteSet().add(piste);
        piste.getSkier().add(skier);
        return skierRepository.save(skier);
    }

    @Override
    public List<Skier> retrieveSkiersBySubscriptionType(TypeSubscription type) {
        return skierRepository.findBySubscriptionTypeSub(type);
    }
}
