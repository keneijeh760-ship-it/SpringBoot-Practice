package com.phope.hope.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long accountNumber;
    private double balance;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    public Account () {}
    public Account (long accountNumber, double balance, User user){
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.user = user;
    }

    public  double getBalance (){
        return balance;
    }

    public long getAccountNumber(){
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



    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setId(long id) {this.id = id;}
}
