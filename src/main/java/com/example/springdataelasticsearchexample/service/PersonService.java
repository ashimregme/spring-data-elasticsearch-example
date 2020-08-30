package com.example.springdataelasticsearchexample.service;

import com.example.springdataelasticsearchexample.exception.BadRequestException;
import com.example.springdataelasticsearchexample.exception.NotFoundException;
import com.example.springdataelasticsearchexample.model.Person;
import com.example.springdataelasticsearchexample.repository.PersonRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person save(Person person) {
        if(person == null) {
            throw new BadRequestException();
        }
        return personRepository.save(person);
    }

    public Person get(String id) {
        Optional<Person> optionalUser = personRepository.findById(id);
        if(optionalUser.isPresent()) {
            return optionalUser.get();
        }
        throw new NotFoundException();
    }

    public void delete(String id) {
        personRepository.deleteById(id);
    }

    public Page<Person> getUsers(int page, int size) {
        return personRepository.findAll(PageRequest.of(page, size));
    }

    public List<Person> findUsersByLastName(String lastName) {
        return personRepository.findPersonsByLastName(lastName);
    }

    public List<Person> findUsersByLastNameAndAge(String lastName, int age) {
        return personRepository.findPersonsByLastNameAndAge(lastName, age);
    }
}
