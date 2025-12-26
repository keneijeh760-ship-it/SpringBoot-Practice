package com.phope.hope.Controller;

import com.phope.hope.DTO.TransactionResponseDTO;
import com.phope.hope.DTO.TransferRequest;
import com.phope.hope.Entity.Transaction;
import com.phope.hope.Entity.User;
import com.phope.hope.Repository.UserRepository;
import com.phope.hope.Service.BankingService;
import com.phope.hope.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final BankingService bankingService;
    private final TransactionService transactionService;
    private final UserRepository userRepository;

    @Autowired
    public TransactionController(TransactionService transactionService,
                                 BankingService bankingService,
                                 UserRepository userRepository) {
        this.transactionService = transactionService;
        this.bankingService = bankingService;
        this.userRepository = userRepository;
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public List<TransactionResponseDTO> findAll() {
        return transactionService.findAllTransactions()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/me")
    @PreAuthorize("hasRole('USER')")
    public List<TransactionResponseDTO> getMyTransactions(Authentication authentication) {
        // Get username from authentication
        String email = authentication.getName();

        // Look up user by email
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Extract account IDs
        List<Long> accountIds = user.getAccounts()
                .stream()
                .map(account -> account.getId())
                .toList();

        // Fetch transactions
        List<Transaction> transactions = transactionService.findTransactionsByAccount(accountIds);

        // Map to DTOs
        return transactions.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @PostMapping("/transfer")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<String> transferMoney(@RequestBody TransferRequest request) {
        bankingService.TransferMoney(
                request.getFromAccountId(),
                request.getToAccountId(),
                request.getAmount()
        );
        return ResponseEntity.ok("Transfer successful");
    }

    private TransactionResponseDTO mapToDTO(Transaction transaction) {
        TransactionResponseDTO dto = new TransactionResponseDTO();
        dto.setId(transaction.getId());
        dto.setFromAccountNumber(transaction.getFrom().getAccountNumber());
        dto.setToAccountNumber(transaction.getTo().getAccountNumber());
        dto.setAmount(transaction.getAmount());
        dto.setStatus(transaction.getStatus());
        dto.setTimestamp(transaction.getTimestamp());
        return dto;
    }
}