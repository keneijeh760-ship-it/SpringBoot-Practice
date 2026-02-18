package org.example.mock2.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Expense {
    @Id
    @SequenceGenerator(
            name = "expense_Id",
            sequenceName = "expense_Id",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "expense_Id",
            strategy = GenerationType.SEQUENCE

    )
    private Long id;
    private String title;
    private BigDecimal amount;
    private LocalDate date;
    @ManyToOne
    @JoinColumn(name = "category_Id")
    private Category category;

}
