package com.esprit.kameltounsi4ds3.services;

import com.esprit.kameltounsi4ds3.Repositories.IRegistrationRepository;
import com.esprit.kameltounsi4ds3.entities.Registration;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class RegistrationServicesImpl implements IRegistrationServices{
private IRegistrationRepository repository;
    @Override
    public Registration addRegistration(Registration subscription) {
        return repository.save(subscription) ;
    }

    @Override
    public Registration updateRegistration(Registration subscription) {
        return repository.save(subscription) ;
    }

    @Override
    public Registration retrieveRegistration(Long numRegistration) {
        return repository.findById(numRegistration).orElse(null) ;
    }

    @Override
    public void removeRegistration(Long numRegistration) {
        repository.deleteById(numRegistration) ;
    }

    @Override
    public List<Registration> retrieveAll() {
        return repository.findAll() ;
    }
}
