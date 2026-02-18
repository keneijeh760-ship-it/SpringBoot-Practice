package org.example.mock2.DTO;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoryResponseDTO {
    private String categoryName;
    private String categoryDescription;
}
