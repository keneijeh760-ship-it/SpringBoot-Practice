package org.example.mock2.DTO;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseResponseDTO {
    private  String title;
    private BigDecimal amount;
    private LocalDateTime date;
    private String categoryName;
}
