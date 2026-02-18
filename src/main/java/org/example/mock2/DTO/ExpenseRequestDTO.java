package org.example.mock2.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
@Data
@Builder
@RequiredArgsConstructor
public class ExpenseRequestDTO {
    @NotBlank
    private String title;
    @Positive
    private BigDecimal amount;
    @NonNull
    private Long categoryId;
}
