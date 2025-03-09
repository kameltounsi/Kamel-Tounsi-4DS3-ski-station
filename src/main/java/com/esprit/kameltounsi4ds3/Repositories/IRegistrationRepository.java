package com.esprit.kameltounsi4ds3.Repositories;

import com.esprit.kameltounsi4ds3.entities.Registration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRegistrationRepository extends JpaRepository<Registration, Long> {
}
