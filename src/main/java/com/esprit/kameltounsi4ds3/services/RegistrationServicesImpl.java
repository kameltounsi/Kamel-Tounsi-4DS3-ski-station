package com.esprit.kameltounsi4ds3.services;

import com.esprit.kameltounsi4ds3.Repositories.ICourseRepository;
import com.esprit.kameltounsi4ds3.Repositories.IRegistrationRepository;
import com.esprit.kameltounsi4ds3.Repositories.ISkierRepository;
import com.esprit.kameltounsi4ds3.entities.Course;
import com.esprit.kameltounsi4ds3.entities.Registration;
import com.esprit.kameltounsi4ds3.entities.Skier;
import com.esprit.kameltounsi4ds3.entities.Support;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
@Service
@AllArgsConstructor
public class RegistrationServicesImpl implements IRegistrationServices{
private IRegistrationRepository repository;
    private ISkierRepository skierRepository;  // Inject SkierRepository
    private ICourseRepository courseRepository;
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
    @Override
    public Registration addRegistrationAndAssignToSkier(Registration registration, Long numSkier) {
        Skier skier = skierRepository.findById(numSkier).orElse(null);
        registration.setSkier(skier);
        return repository.save(registration);
    }

    @Override
    public Registration assignRegistrationToCourse(Long numRegistration, Long numCourse) {
        Registration registration = repository.findById(numRegistration).orElse(null);
        Course course = courseRepository.findById(numCourse).orElse(null);
        assert registration != null;
        registration.setCourse(course);
        return repository.save(registration);
    }

    @Override
    public Registration addRegistrationAndAssignToSkierAndCourse(Registration registration, Long numSkieur, Long numCours) {
        Skier skier = skierRepository.findById(numSkieur).orElse(null);
        Course course = courseRepository.findById(numCours).orElse(null);

        if (skier == null || course == null) {
            return null; // Skier or Course doesn't exist
        }

        // Check if registration already exists for this week and course
        boolean alreadyRegistered = repository.countDistinctByNumWeekAndSkier_NumSkierAndCourse_NumCourse(
                registration.getNumWeek(), skier.getNumSkier(), course.getNumCourse()) >= 1;

        if (alreadyRegistered) {
            return null; // Already registered for this course and week
        }

        int ageSkieur = Period.between(skier.getDateOfBirth(), LocalDate.now()).getYears();

        switch (course.getTypeCourse()) {
            case INDIVIDUAL:
                // No restrictions for individual
                return assignRegistration(registration, skier, course);

            case COLLECTIVE_CHILDREN:
                if (ageSkieur < 16) {
                    // Max 6 skiers allowed per course per week
                    if (repository.countByCourseAndNumWeek(course, registration.getNumWeek()) < 6) {
                        return assignRegistration(registration, skier, course);
                    }
                }
                break;

            case COLLECTIVE_ADULT:
                if (ageSkieur >= 16) {
                    // Max 6 skiers allowed per course per week
                    if (repository.countByCourseAndNumWeek(course, registration.getNumWeek()) < 6) {
                        return assignRegistration(registration, skier, course);
                    }
                }
                break;
        }

        return null; // Registration not allowed
    }
    private Registration assignRegistration(Registration registration, Skier skier, Course course) {
        registration.setSkier(skier);
        registration.setCourse(course);
        return repository.save(registration);
    }

    @Override
    public int getNumWeeksCourseOfInstructorBySupport(Long numInstructor, Support support) {
        return repository.countDistinctWeeksByInstructorAndSupport(numInstructor, support);
    }
}
