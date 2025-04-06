package com.esprit.kameltounsi4ds3.Repositories;

import com.esprit.kameltounsi4ds3.entities.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface IInstructorRepository extends JpaRepository<Instructor, Long> {
    List<Instructor> findByDateOfHire(LocalDate dateOfHire);

}
