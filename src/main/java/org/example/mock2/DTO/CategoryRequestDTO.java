package org.example.mock2.DTO;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
public class CategoryRequestDTO {
    private Long Id;
    private String categoryName;
    private String description;
}
