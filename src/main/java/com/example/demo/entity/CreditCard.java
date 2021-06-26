
package com.example.demo.entity;

import java.io.Serializable;
import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "Credit_Card")
public class CreditCard {
 @Id
 @Column(name = "id")
 @GeneratedValue(strategy=GenerationType.IDENTITY)
 private int id;
 
  
 @Column(name = "type")
 private String type;
 
 @Column(name = "number")
 private String number;
 
 @ManyToOne 
 @JoinColumn(name = "person_fk")
 private Person person;

 public int getId() {
  return id;
 }

 public void setId(int id) {
  this.id = id;
 }

 public String getType() {
  return type;
 }

 public void setType(String type) {
  this.type = type;
 }

 public String getNumber() {
  return number;
 }

 public void setNumber(String number) {
  this.number = number;
 }

    

    public CreditCard() {
    }

    public CreditCard(int id, String type, String number) {
        this.id = id;
        this.type = type;
        this.number = number;
    }

    @Override
    public String toString() {
        return "CreditCard{" + "id=" + id + ", type=" + type + ", number=" + number + '}';
    }
 
 
 
}
