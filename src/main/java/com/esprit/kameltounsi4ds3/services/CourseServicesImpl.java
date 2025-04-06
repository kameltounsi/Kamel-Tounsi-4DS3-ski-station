package com.esprit.kameltounsi4ds3.services;

import com.esprit.kameltounsi4ds3.Repositories.ICourseRepository;
import com.esprit.kameltounsi4ds3.entities.Course;
import com.esprit.kameltounsi4ds3.entities.Support;
import com.esprit.kameltounsi4ds3.entities.TypeCourse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class CourseServicesImpl implements ICourseServices{
    private ICourseRepository courseRepository;
    @Override
    public List<Course> retrieveAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course updateCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course retrieveCourse(Long numCourse) {
        return courseRepository.findById(numCourse).orElse(null);
    }

    @Override
    public void deleteCourse(Long numCourse) {
        courseRepository.deleteById(numCourse);
    }
    @Override
    public List<Course> getCoursesByInstructorAndSupport(Long numInstructor, Support support) {
        return courseRepository.findByInstructorNumInstructorAndSupport(numInstructor, support);
    }

    @Override
    public List<Course> getCoursesByType(TypeCourse typeCourse, int numWeek) {
        return courseRepository.findByTypeCourseAndRegistrationsNumWeek(typeCourse, numWeek);
    }
}
