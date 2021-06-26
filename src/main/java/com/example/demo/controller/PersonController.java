/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controller;

import com.example.demo.entity.CreditCard;
import com.example.demo.entity.Person;
import com.example.demo.repository.CreditCardRepository;
import com.example.demo.repository.PersonRepository;
import com.example.demo.service.PersonService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author PhamNgocNhuY_18055121
 */
@RestController
public class PersonController {
    
    private PersonService personService;
    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }
 
    @PostMapping("/persons")
    public Person addPerson(@RequestBody Person thePerson ) {
        personService.save(thePerson);	
        return thePerson;
    }

    @PutMapping("/persons")
    public Person updatePerson(@RequestBody Person thePerson) {   
        Person p= personService.findById(thePerson.getId());
        p.setFirstName(thePerson.getFirstName());
        p.setLastName(thePerson.getLastName());
        p.setMoney(thePerson.getMoney());
        personService.save(p);
        return p;
        
    }
    @DeleteMapping("/persons/{personId}")
    public String deletePerson(@PathVariable int personId) {
            personService.deleteById(personId);
            return "Deleted person id - " + personId;
    }
        @GetMapping("/persons")
    public List<Person> getPersons() {
	List<Person> thePerson = personService.findAll();
        return thePerson; 
    }
    @GetMapping("/persons/{personId}")
    public Person getPerson(@PathVariable Integer personId) {
            Person thePerson = personService.findById(personId);
            return thePerson;
    }
    
    
    
}
