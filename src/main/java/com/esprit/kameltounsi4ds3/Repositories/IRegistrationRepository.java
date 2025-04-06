package com.esprit.kameltounsi4ds3.Repositories;

import com.esprit.kameltounsi4ds3.entities.Course;
import com.esprit.kameltounsi4ds3.entities.Registration;
import com.esprit.kameltounsi4ds3.entities.Support;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IRegistrationRepository extends JpaRepository<Registration, Long> {
    @Query("SELECT COUNT(DISTINCT r.numWeek) FROM Registration r WHERE r.course.instructor.numInstructor = :numInstructor AND r.course.support = :support")
    int countDistinctWeeksByInstructorAndSupport(@Param("numInstructor") Long numInstructor, @Param("support") Support support);
    long countByCourseAndNumWeek(Course course, int numWeek);
    @Query("select reg.numWeek from Registration reg " +
            "join Instructor ins " +
            "on reg.course member ins.Course " +
            "where ins.numInstructor = :idIns and reg.course.support = :support")
    List<Integer> numWeeksCourseOfInstructorBySupport(@Param("idIns") Long numInstructor, @Param("support") Support support);

    @Query("select count(distinct r) from Registration r " +
            "where r.numWeek = ?1 and r.skier.numSkier = ?2 and r.course.numCourse = ?3")
    long countDistinctByNumWeekAndSkier_NumSkierAndCourse_NumCourse(int numWeek, Long numSkier, Long numCourse);


}
