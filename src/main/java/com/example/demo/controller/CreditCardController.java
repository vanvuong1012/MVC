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
import com.example.demo.service.CreditCardService;
import com.example.demo.service.PersonService;
import java.util.List;
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
public class CreditCardController {
    @Autowired
    private PersonService personRepository;
    @Autowired
    private CreditCardService creditCardRepository;
    
    @Autowired 
    private CreditCardRepository creditCardRepository1;
    @Autowired 
    private PersonRepository personRepository1;
    
     @GetMapping("/persons/{personId}/creditcards")
    public List<CreditCard> getCreditCards(@PathVariable int personId) {
        Person p=  personRepository.findById(personId);
        List<CreditCard> card = p.getCreditCards();
        return card;  
    } 
    
     @PostMapping("/persons/{personId}/creditcards")
    public CreditCard addCreditCard(@RequestBody CreditCard theCard,@PathVariable int personId) {
        Person p=  personRepository.findById(personId);
        p.getCreditCards().add(creditCardRepository.saveAndReturn(theCard));
        personRepository.save(p);
        
        return theCard;
    }
    @PutMapping("/persons/{personId}/creditcards/{creditcardId}")
    public CreditCard updateCreditCard(@RequestBody CreditCard theCard,@PathVariable int personId,@PathVariable int creditcardId)
    {
            Person p=  personRepository.findById(personId);
            int creditCardIndex = p.getCreditCardIndex(creditcardId);
             
            if (creditCardIndex == -1) {
                return null;
            }else {
                 CreditCard card = p.getCreditCards().get(creditCardIndex);
                 card.setNumber(theCard.getNumber());
                 card.setType(theCard.getType());
                 p.getCreditCards().set(creditCardIndex, card);
                 
                 personRepository.save(p);
                 return card;
            }

    }
    
      @DeleteMapping("persons/{personId}/creditcards/{creditcardId}")
    public String deleteCreditCard(@PathVariable int personId ,@PathVariable int creditcardId) {
       // CreditCard temp= creditCardRepository.getById(creditcardId);
       
            Person p=  personRepository.findById(personId);
            CreditCard cr = p.getCreditCard(creditcardId);
             
            if (cr == null) {
                return "creditcard not found";
            }else {
                Boolean temp = p.getCreditCards().remove(cr);
                if (temp) {
                    creditCardRepository.deleteById(creditcardId);
                    personRepository.save(p);
                    return "delete success";
                }else {
                    return "delete fail";
                }
            }
    }
    
}
