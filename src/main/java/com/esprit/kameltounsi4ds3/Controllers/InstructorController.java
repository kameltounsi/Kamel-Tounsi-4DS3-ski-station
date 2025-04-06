package com.esprit.kameltounsi4ds3.Controllers;

import com.esprit.kameltounsi4ds3.entities.Instructor;
import com.esprit.kameltounsi4ds3.services.ICourseServices;
import com.esprit.kameltounsi4ds3.services.IInstructorServices;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("instructor")
@AllArgsConstructor
public class InstructorController {
    private IInstructorServices instructorServices;
    @PostMapping("add")
    public Instructor addInstructor(@RequestBody Instructor instructor) {
        return instructorServices.addInstructor(instructor);
    }
    @GetMapping("all")
    public List<Instructor> retrieveAll() {
        return instructorServices.retrieveInstructors();
    }

    @PutMapping("update")
    public Instructor updateInstructor(@RequestBody Instructor instructor)
    {
        return instructorServices.updateInstructor(instructor);
    }
    @GetMapping("get/{numInstructor}")
    public Instructor retrieveInstructor(@PathVariable Long numInstructor) {
        return instructorServices.retrieveInstructor(numInstructor);
    }
    @GetMapping("delete/{numInstructor}")
    public void removeInstructor(@PathVariable Long numInstructor)
    {
        instructorServices.deleteInstructor(numInstructor);
    }
    @PostMapping("addAndAssignToCourse/{numCourse}")
    public Instructor addInstructorAndAssignToCourse(@RequestBody Instructor instructor, @PathVariable Long numCourse) {
        return instructorServices.addInstructorAndAssignToCourse(instructor, numCourse);
    }

    @GetMapping("byDateOfHire/{dateOfHire}")
    public List<Instructor> getInstructorsByDate(@PathVariable LocalDate dateOfHire) {
        return instructorServices.getInstructorsByDate(dateOfHire);
    }
}
