package com.example.springdataelasticsearchexample.controller;

import com.example.springdataelasticsearchexample.model.Person;
import com.example.springdataelasticsearchexample.service.PersonService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("person")
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public Person save(@RequestBody Person person) {
        return personService.save(person);
    }

    @GetMapping("{id}")
    public Person get(@PathVariable String id) {
        return personService.get(id);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable String id) {
        personService.delete(id);
    }

    @GetMapping
    public Page<Person> getAll(@RequestParam int page, @RequestParam int size) {
        return personService.getUsers(page, size);
    }

    @GetMapping("searchByLastName")
    public List<Person> searchByLastName(@RequestParam("last_name") String lastName) {
        return personService.findUsersByLastName(lastName);
    }

    @GetMapping("searchByLastNameAndAge")
    public List<Person> searchByLastNameAndAge(@RequestParam("last_name") String lastName, @RequestParam int age) {
        return personService.findUsersByLastNameAndAge(lastName, age);
    }
}
