package com.esprit.kameltounsi4ds3.services;

import com.esprit.kameltounsi4ds3.entities.Registration;
import com.esprit.kameltounsi4ds3.entities.Subscription;
import com.esprit.kameltounsi4ds3.entities.Support;

import java.util.List;

public interface IRegistrationServices {
    Registration addRegistration(Registration subscription);
    Registration updateRegistration(Registration subscription);
    Registration retrieveRegistration(Long numRegistration);
    void removeRegistration(Long numRegistration);
    List<Registration> retrieveAll();
    Registration addRegistrationAndAssignToSkier(Registration registration, Long numSkieur);
    Registration assignRegistrationToCourse(Long numRegistration, Long numCourse);
    Registration addRegistrationAndAssignToSkierAndCourse(Registration registration, Long numSkieur, Long numCours);


    int getNumWeeksCourseOfInstructorBySupport(Long numInstructor, Support support);
}
