package com.heapsteep.controller;

import com.heapsteep.entity.Person;
import com.heapsteep.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MyGraphController {
    @Autowired
    MyService myService;

    @QueryMapping
    public Iterable<Person> getPersons() {
        return myService.getPersons();
    }

    @QueryMapping
    public Person getPersonById(@Argument String id){
        return myService.getPersonById(id);
    }

    @MutationMapping
    public Person updatePersonName(@Argument String id, @Argument String name){
        return myService.updatePerson(id,name);
    }

}