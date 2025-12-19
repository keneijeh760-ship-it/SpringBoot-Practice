package com.phope.hope.Service;

import com.phope.hope.DTO.AccountResponseDTO;
import com.phope.hope.DTO.UserRequestDTO;
import com.phope.hope.DTO.UserResponseDTO;
import com.phope.hope.Entity.Account;
import com.phope.hope.Entity.User;
import com.phope.hope.Repository.AccountRepository;
import com.phope.hope.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class BankingService {


    private final AccountRepository accountRepository;
    private final UserRepository userRepository;

    public BankingService(AccountRepository accountRepository, UserRepository userRepository){

        this.accountRepository = accountRepository;
        this.userRepository = userRepository;
    }

    public UserResponseDTO mapToUserResponse(User user) {
        UserResponseDTO dto = new UserResponseDTO();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setAccounts(user.getAccounts().stream()
                .map(this::mapToAccountResponse)
                .collect(Collectors.toList()));
        return dto;
    }

    public AccountResponseDTO mapToAccountResponse(Account account) {
        AccountResponseDTO dto = new AccountResponseDTO();
        dto.setAccountNumber(account.getAccountNumber());
        dto.setBalance(account.getBalance());
        return dto;
    }

    public User mapToUserEntity(UserRequestDTO dto) {
        User user = new User();
        user.setName(dto.getName());
        if (dto.getAccount() != null) {
            dto.getAccount().forEach(a -> {
                Account account = new Account();
                account.setAccountNumber(a.getAccountNumber());
                account.setBalance(a.getBalance());
                user.addAccount(account);
            });
        }
        return user;
    }


    public UserResponseDTO createUser(UserRequestDTO dto) {
        User userEntity = mapToUserEntity(dto);
        User savedUser = userRepository.save(userEntity);
        return mapToUserResponse(savedUser);
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
