package com.esprit.kameltounsi4ds3.Controllers;

import com.esprit.kameltounsi4ds3.entities.Course;
import com.esprit.kameltounsi4ds3.entities.Skier;
import com.esprit.kameltounsi4ds3.services.ICourseServices;
import com.esprit.kameltounsi4ds3.services.ISkierServices;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("course")
@AllArgsConstructor
public class CourseController {
    private ICourseServices courseServices;
    @PostMapping("add")
    public Course addCourse(@RequestBody Course course) {
        return courseServices.addCourse(course);
    }
    @GetMapping("all")
    public List<Course> retrieveAll() {
        return courseServices.retrieveAllCourses();
    }

    @PutMapping("update")
    public Course updateCourse(@RequestBody Course course)
    {
        return courseServices.updateCourse(course);
    }
    @GetMapping("get/{numCourse}")
    public Course retrieveCourse(@PathVariable Long numCourse) {
        return courseServices.retrieveCourse(numCourse);
    }
    @GetMapping("delete/{numCourse}")
    public void removeCourse(@PathVariable Long numCourse)
    {
        courseServices.deleteCourse(numCourse);
    }
}
