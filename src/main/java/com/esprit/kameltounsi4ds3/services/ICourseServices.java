package com.esprit.kameltounsi4ds3.services;

import com.esprit.kameltounsi4ds3.entities.Course;
import com.esprit.kameltounsi4ds3.entities.Support;
import com.esprit.kameltounsi4ds3.entities.TypeCourse;

import java.util.List;

public interface ICourseServices {
    List<Course> retrieveAllCourses();
    Course addCourse(Course course);
    Course updateCourse(Course course);
    Course retrieveCourse(Long numCourse);
    void deleteCourse(Long numCourse);

    List<Course> getCoursesByInstructorAndSupport(Long numInstructor, Support support);

    List<Course> getCoursesByType(TypeCourse typeCourse, int numWeek);
}
