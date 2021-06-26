/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service;

import com.example.demo.entity.CreditCard;

 

/**
 *
 * @author PhamNgocNhuY_18055121
 */
public interface CreditCardService {
    public void save(CreditCard theCard);
    public CreditCard saveAndReturn(CreditCard theCard);
    public void deleteById(int theId); 
}
