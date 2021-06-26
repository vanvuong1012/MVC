/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service;

import com.example.demo.entity.CreditCard;
import com.example.demo.repository.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author PhamNgocNhuY_18055121
 */
@Service
public class CreditCardServiceImpl implements CreditCardService{
    CreditCardRepository creditCardRepository;
    @Autowired
    public CreditCardServiceImpl(CreditCardRepository creditCardRepository) {
        this.creditCardRepository = creditCardRepository;
    }
    
    @Override
    public void save(CreditCard theCard) {
        creditCardRepository.save(theCard);
    }

    @Override
    public void deleteById(int theId) {
        creditCardRepository.deleteById(theId);
    }

    @Override
    public CreditCard saveAndReturn(CreditCard theCard) {
         return creditCardRepository.save(theCard);     
    }
    
}
