package com.phope.hope.Entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Product {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private double price;


    public Product(String name, double price){
        this.name = name;
        this.price = price;
    }

}
