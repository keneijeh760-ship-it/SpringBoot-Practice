package org.example.mock2.Repository;

import org.example.mock2.DTO.ExpenseResponseDTO;
import org.example.mock2.Entities.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExpsenseRepository extends JpaRepository<Expense, Long> {

    public List<ExpenseResponseDTO> findAllExpenses();


    public Optional<Expense> findExpenseByTitle(String title);


}
