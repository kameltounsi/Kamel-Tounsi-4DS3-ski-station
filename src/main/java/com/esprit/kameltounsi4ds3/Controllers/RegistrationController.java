package com.esprit.kameltounsi4ds3.Controllers;

import com.esprit.kameltounsi4ds3.entities.Instructor;
import com.esprit.kameltounsi4ds3.entities.Registration;
import com.esprit.kameltounsi4ds3.entities.Support;
import com.esprit.kameltounsi4ds3.services.IInstructorServices;
import com.esprit.kameltounsi4ds3.services.IRegistrationServices;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("registration")
@AllArgsConstructor
public class RegistrationController {
    private IRegistrationServices registrationServices;
    @PostMapping("add")
    public Registration addRegistration(@RequestBody Registration registration) {
        return registrationServices.addRegistration(registration);
    }
    @GetMapping("all")
    public List<Registration> retrieveAll() {
        return registrationServices.retrieveAll();
    }

    @PutMapping("update")
    public Registration updateRegistration(@RequestBody Registration registration)
    {
        return registrationServices.updateRegistration(registration);
    }
    @GetMapping("get/{numRegistration}")
    public Registration retrieveRegistration(@PathVariable Long numRegistration) {
        return registrationServices.retrieveRegistration(numRegistration);
    }
    @GetMapping("delete/{numRegistration}")
    public void removeRegistration(@PathVariable Long numRegistration)
    {
        registrationServices.removeRegistration(numRegistration);
    }

    @PostMapping("add/{numSkier}")
    public Registration addRegistrationAndAssignToSkier(@RequestBody Registration registration, @PathVariable Long numSkier) {
        return registrationServices.addRegistrationAndAssignToSkier(registration, numSkier);
    }

    @PutMapping("assign/{numRegistration}/{numCourse}")
    public Registration assignRegistrationToCourse(@PathVariable Long numRegistration, @PathVariable Long numCourse) {
        return registrationServices.assignRegistrationToCourse(numRegistration, numCourse);
    }
    @GetMapping("numWeeksByInstructorAndSupport/{numInstructor}/{support}")
    public int getNumWeeksCourseOfInstructorBySupport(@PathVariable Long numInstructor, @PathVariable Support support) {
        return registrationServices.getNumWeeksCourseOfInstructorBySupport(numInstructor, support);
    }
}
