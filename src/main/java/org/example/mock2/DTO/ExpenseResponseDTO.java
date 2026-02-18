package org.example.mock2.DTO;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@RequiredArgsConstructor
public class ExpenseResponseDTO {
    private  String title;
    private BigDecimal amount;
    private LocalDateTime date;
    private String categoryName;
}
