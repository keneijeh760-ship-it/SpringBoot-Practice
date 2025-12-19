package com.phope.hope.Service;

import com.phope.hope.Entity.Account;
import com.phope.hope.Repository.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class BankingService {

    private final AccountRepository accountRepository;

    public BankingService(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    public void TransferMoney(long fromId, long toId, double amount){
        Account from  = accountRepository.findById(fromId).orElseThrow(() -> new RuntimeException("Account not found"));
        Account to = accountRepository.findById(toId).orElseThrow(() -> new RuntimeException("Account not found"));

        if (from.getBalance() < amount){
            throw new RuntimeException("Insufficent Funds");
        }

        from.setBalance(from.getBalance() - amount);
        to.setBalance(from.getBalance() + amount);

        accountRepository.save(from);
        accountRepository.save(to);

    }
}
