package com.phope.hope.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String accountNumber;
    private double balance;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Account () {}
    public Account (String accountNumber, double balance, User user){
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.user = user;
    }

    public  double getBalance (){
        return balance;
    }

    public   String getAccountNumber(){
        return accountNumber;
    }

    public long getId() {
        return id;
    }
    @JsonIgnore
    public User getUser() {
        return user;
    }

    public void setBalance(double balance){
        this.balance = balance;
    }



    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
