package com.esprit.kameltounsi4ds3.Repositories;

import com.esprit.kameltounsi4ds3.entities.Course;
import com.esprit.kameltounsi4ds3.entities.Support;
import com.esprit.kameltounsi4ds3.entities.TypeCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByInstructorNumInstructorAndSupport(Long numInstructor, Support support);

    @Query("SELECT c FROM Course c JOIN c.registrations r WHERE c.typeCourse = :typeCourse AND r.numWeek = :numWeek")
    List<Course> findByTypeCourseAndRegistrationsNumWeek(@Param("typeCourse") TypeCourse typeCourse, @Param("numWeek") int numWeek);
}
