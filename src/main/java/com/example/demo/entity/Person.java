/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.entity;

/**
 *
 * @author PhamNgocNhuY_18055121
 */
 
 
import java.util.List;
import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
 
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Person")
public class Person {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "money")
    private Double money;

    @OneToMany(fetch = FetchType.EAGER,targetEntity = CreditCard.class , cascade = CascadeType.ALL)
    @JoinColumn(name = "person_fk",referencedColumnName = "id")
    private List<CreditCard> creditCards;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public List<CreditCard> getCreditCards() {
        return creditCards;
    }
    
    public int getCreditCardIndex (int creditCardId) {
        for (int i = 0; i < this.getCreditCards().size(); i++) {
            if(this.getCreditCards().get(i).getId() == creditCardId)
                return i;
        }
        return -1;
    }

    public CreditCard getCreditCard(int creditCardId) {
        if (creditCards != null) {
            for (CreditCard theCredictCard : creditCards) {
                if (theCredictCard.getId() == creditCardId) {
                    return theCredictCard;
                }
            }
        }
        return null;
    }

    public void setCreditCards(List<CreditCard> creditCards) {
        this.creditCards = creditCards;
    }

//    public void addCreditCard(CreditCard theCreditCard) {
//        if (creditCards == null) {
//            creditCards = new ArrayList<>();
//        }
//        creditCards.add(theCreditCard);
//    }

    public Person(int id, String firstName, String lastName, Double money, List<CreditCard> creditCards) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.money = money;
        this.creditCards = creditCards;
    }
    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", money=" + money + ", creditCards=" + creditCards + '}';
    }
    
    
    
}
