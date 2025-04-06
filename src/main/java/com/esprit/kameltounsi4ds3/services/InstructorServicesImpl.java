package com.esprit.kameltounsi4ds3.services;

import com.esprit.kameltounsi4ds3.Repositories.ICourseRepository;
import com.esprit.kameltounsi4ds3.Repositories.IInstructorRepository;
import com.esprit.kameltounsi4ds3.entities.Course;
import com.esprit.kameltounsi4ds3.entities.Instructor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
@Service
@AllArgsConstructor
public class InstructorServicesImpl implements IInstructorServices{
    IInstructorRepository instructorRepository;
    private final ICourseRepository courseRepository;
    @Override
    public List<Instructor> retrieveInstructors() {
        return instructorRepository.findAll();
    }

    @Override
    public Instructor addInstructor(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    @Override
    public Instructor updateInstructor(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    @Override
    public Instructor retrieveInstructor(Long numInstructor) {
        return instructorRepository.findById(numInstructor).orElse(null);
    }

    @Override
    public void deleteInstructor(Long numInstructor) {
        instructorRepository.deleteById(numInstructor);
    }
    @Override
    @Transactional
    public Instructor addInstructorAndAssignToCourse(Instructor instructor, Long numCourse) {
        Course course = courseRepository.findById(numCourse)
                .orElseThrow(() -> new RuntimeException("Course not found with ID: " + numCourse));
        instructor = instructorRepository.save(instructor);
        course.setInstructor(instructor);
        instructor.getCourse().add(course);
        courseRepository.save(course);
        return instructor;
    }

    @Override
    public List<Instructor> getInstructorsByDate(LocalDate dateOfHire) {
        return instructorRepository.findByDateOfHire(dateOfHire);
    }


}
