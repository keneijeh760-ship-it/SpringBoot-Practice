package org.example.mock2.DTO;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoryRequestDTO {
    private Long Id;
    private String categoryName;
    private String description;
}
