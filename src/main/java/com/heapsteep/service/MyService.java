package com.heapsteep.service;

import com.heapsteep.entity.Person;
import com.heapsteep.repository.MyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyService {
    @Autowired
    MyRepository myRepository;

    public Iterable<Person> getPersons() {
        return myRepository.findAll();
    }

    public Person addPerson(Person person) {
        return myRepository.save(person);
    }

    public Person updatePerson(String id, String name) {
        Person person = myRepository.findById(id).get();
        person.setName(name);

        return myRepository.save(person);
    }

    public Person getPersonById(String id) {
        Person person = myRepository.findById(id).get();
        return person;
    }

    public void deletePerson(String id) {
        myRepository.deleteById(id);
    }
}