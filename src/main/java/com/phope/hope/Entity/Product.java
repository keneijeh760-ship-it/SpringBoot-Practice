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

    public String getName(){
        return this.name;
    }

    public double getPrice () {
        return this.price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public long getId (){
        return this.id;
    }

    public void setId (long id){
        this.id = id;
    }



}
