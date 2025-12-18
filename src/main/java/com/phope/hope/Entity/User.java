package com.phope.hope.Entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Account> accounts = new ArrayList<>();

    public User() {}

    public User (String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
    public long getId() {
        return id;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setAccounts(List<Account> accounts){
        this.accounts = accounts;

        if (accounts != null){
            for (Account account: accounts){
                account.setUser(this);
            }
        }


    }

    public void addAccount(Account account) {
        accounts.add(account);
        account.setUser(this);
    }






}
