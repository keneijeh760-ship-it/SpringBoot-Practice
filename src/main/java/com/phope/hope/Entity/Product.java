package com.phope.hope.Entity;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Product {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private double price;

    public Product() {
    }


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
