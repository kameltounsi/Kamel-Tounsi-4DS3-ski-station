package com.esprit.kameltounsi4ds3.services;

import com.esprit.kameltounsi4ds3.entities.Instructor;
import com.esprit.kameltounsi4ds3.entities.Registration;

import java.util.List;

public interface IInstructorServices {
    List<Instructor> retrieveInstructors();
    Instructor addInstructor(Instructor instructor);
    Instructor updateInstructor (Instructor instructor);
    Instructor retrieveInstructor (Long numInstructor);
    void deleteInstructor (Long numInstructor);
}
