package org.example.mock2.Services;

import lombok.RequiredArgsConstructor;
import org.example.mock2.DTO.ExpenseRequestDTO;
import org.example.mock2.DTO.ExpenseResponseDTO;
import org.example.mock2.Entities.Category;
import org.example.mock2.Entities.Expense;
import org.example.mock2.Exception.ApiRequestExceptions;
import org.example.mock2.Repository.CategoryRepository;
import org.example.mock2.Repository.ExpsenseRepository;
import org.example.mock2.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExpenseService {

    private  final UserRepository  userRepository;
    private final ExpsenseRepository expsenseRepository;
    private final CategoryRepository categoryRepository;

    public ExpenseResponseDTO createExpense(ExpenseRequestDTO expenseRequestDTO) {
        Category category = categoryRepository.findById(expenseRequestDTO.getCategoryId())
                .orElseThrow(() -> new ApiRequestExceptions("Category not found"));

        Expense expense = Expense.builder()
                .amount(expenseRequestDTO.getAmount())
                .title(expenseRequestDTO.getTitle())
                .category(category)
                .build();
        Expense saedExpense = expsenseRepository.save(expense);



        return ExpenseResponseDTO.builder()
                .title(saedExpense.getTitle())
                .amount(saedExpense.getAmount())
                .date(LocalDateTime.now())
                .build();

    }

    public List<ExpenseResponseDTO> getAllExpenses() {
        return expsenseRepository.findAllExpenses();
    }

    public ExpenseResponseDTO updateExpense(String title, BigDecimal amount) {
        Expense expenseupdate = expsenseRepository.findExpenseByTitle(title)
                .orElseThrow(() -> new ApiRequestExceptions("Expense not found"));





        if (expenseupdate.getTitle().equals(title) && expenseupdate.getAmount().equals(amount)) {
            throw new ApiRequestExceptions("Expense title didnt change");
        }else{
            expenseupdate.setTitle(title);
            expenseupdate.setAmount(amount);
        }

        expsenseRepository.save(expenseupdate);

        return ExpenseResponseDTO.builder()
                .title(expenseupdate.getTitle())
                .amount(expenseupdate.getAmount())
                .date(LocalDateTime.now())
                .build();





    }

    public void deleteExpense(String title) {
        Expense expense = expsenseRepository.findExpenseByTitle(title)
                .orElseThrow(() -> new ApiRequestExceptions("Expense not found"));

        expsenseRepository.delete(expense);
    }
}
