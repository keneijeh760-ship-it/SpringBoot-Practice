package org.example.mock2.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.math.BigDecimal;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseRequestDTO {
    @NotBlank
    private String title;
    @Positive
    private BigDecimal amount;
    @NonNull
    private Long categoryId;
}
