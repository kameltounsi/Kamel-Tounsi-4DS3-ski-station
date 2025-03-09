package com.esprit.kameltounsi4ds3.services;

import com.esprit.kameltounsi4ds3.entities.Registration;
import com.esprit.kameltounsi4ds3.entities.Subscription;

import java.util.List;

public interface IRegistrationServices {
    Registration addRegistration(Registration subscription);
    Registration updateRegistration(Registration subscription);
    Registration retrieveRegistration(Long numRegistration);
    void removeRegistration(Long numRegistration);
    List<Registration> retrieveAll();
}
