package com.example.annuaire.controller;

import com.example.annuaire.Exceptions.PersonConflictException;
import com.example.annuaire.Exceptions.PersonNotFoundException;
import com.example.annuaire.model.Person;
import com.example.annuaire.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "annuaire/entree")

public class PersonController {

    private final IPersonService personService;

    @Autowired
    public PersonController(IPersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public List<Person> getAllPersons() {
        return personService.getAllPersons();
    }

    @GetMapping(path = "{personId}")
    public Person getPersonFromId(@PathVariable("personId") Long personId) {
        Person optionalPerson = personService.getFromId(personId).orElseThrow(() -> new PersonNotFoundException(String.format("Person with id %s does not exist", personId)));
        return optionalPerson;
    }

    @DeleteMapping(path = "{personId}")
    public void deletePersonFromId(@PathVariable("personId") Long personId) {
        if (!personService.existPerson(personId)) {
            throw new PersonNotFoundException(String.format("Person with id %s does not exist", personId));
        }
        personService.deleteFromId(personId);
    }

    @PostMapping
    public void registerNewPerson(@RequestBody Person person) {
        if (personService.existPersonByPhone(person.getPhone())) {
            throw new PersonConflictException("Person with this phone is already exist");

        }
        personService.addPerson(person);

    }

    @PutMapping(path = "{personId}")
    public void updatePerson(
            @PathVariable("personId") Long personId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String surname,
            @RequestParam(required = false) String phone,
            @RequestParam(required = false) String city
    ){
        if (!personService.existPerson(personId)) {
            throw new PersonNotFoundException(String.format("Person with id %s does not exist", personId));
        }
        if (personService.existPersonByPhone(phone)) {
            throw new PersonConflictException(String.format("Person with this phone %s is already exist", phone));
        }
        personService.updatePerson(personId,name,surname,phone,city);
    }


}
