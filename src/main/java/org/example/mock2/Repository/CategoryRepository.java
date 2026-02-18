package org.example.mock2.Repository;

import org.example.mock2.Entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {

    Optional<Category> findById(Long Id);
    Optional<Category> findByCategoryName(String categoryName);
    Optional<Category> findByUserEmail(String userEmail);
}
