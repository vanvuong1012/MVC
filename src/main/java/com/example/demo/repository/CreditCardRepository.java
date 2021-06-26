/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.repository;

import com.example.demo.entity.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author PhamNgocNhuY_18055121
 */
public interface CreditCardRepository extends JpaRepository<CreditCard, Integer>{
    void delete(CreditCard card);
}
