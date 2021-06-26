/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service;

import com.example.demo.entity.Person;
import java.util.List;

/**
 *
 * @author PhamNgocNhuY_18055121
 */
public interface PersonService {
    public List<Person> findAll();
    public Person findById(int theId);
    public void save(Person theEmployee);
    public void deleteById(int theId); 
}
