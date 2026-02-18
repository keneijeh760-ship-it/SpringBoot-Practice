package org.example.mock2.Services;

import lombok.RequiredArgsConstructor;
import org.example.mock2.DTO.CategoryRequestDTO;
import org.example.mock2.DTO.CategoryResponseDTO;
import org.example.mock2.Entities.Category;
import org.example.mock2.Entities.User;
import org.example.mock2.Exception.ApiRequestExceptions;
import org.example.mock2.Repository.CategoryRepository;
import org.example.mock2.Repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;

    public CategoryResponseDTO createCategory(CategoryRequestDTO categoryRequestDTO, String useremail) {

        User user = userRepository.findByEmail(useremail)
        .orElseThrow(() -> new ApiRequestExceptions("User not found"));

        Category category = Category.builder()
                .name(categoryRequestDTO.getCategoryName())
                .description(categoryRequestDTO.getDescription())
                .user(user)
                .build();


        Category savedCategory = categoryRepository.save(category);

        return CategoryResponseDTO.builder()
                .categoryDescription(
                        savedCategory.getDescription()
                )
                .categoryName(savedCategory.getName()).build();
    }




}
