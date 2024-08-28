package com.northcoders.demospringbootapp.controller;

import com.northcoders.demospringbootapp.model.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1")
public class DemoController {

    @GetMapping("/hello")
    public String greeting(){
        return "Hello there!";
    }

    @GetMapping("/people")
    public List<Person> getPeople() {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Simon", 18, "simon@northcoders.com", "Liverpool", "Pasta"));
        people.add(new Person("Alex", 17, "alex@northcoders.com", "London", "Burger"));
        return people;
    }

}
