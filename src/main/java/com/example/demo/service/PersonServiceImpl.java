/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service;

import com.example.demo.entity.Person;
import com.example.demo.repository.PersonRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author PhamNgocNhuY_18055121
 */
@Service
public class PersonServiceImpl implements PersonService{
    private PersonRepository personRepository;
    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
    
    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public Person findById(int theId) {
        Optional<Person> result = personRepository.findById(theId);
        Person theEmployee = null;
        if (result.isPresent()) {
           theEmployee = result.get(); }
        else {
           throw new RuntimeException("Did not find employee id - " + theId);
        }
        return theEmployee;
    }

    @Override
    public void save(Person theEmployee) {
        personRepository.save(theEmployee);
    }

    @Override
    public void deleteById(int theId) {
         personRepository.deleteById(theId);
    }
    
}
