package org.example.mock2.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    @Id
    @SequenceGenerator(
            name = "category_Id",
            sequenceName = "category_Id",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "category_Id",
            strategy = GenerationType.SEQUENCE

    )
    private Long id;
    private String name;
    private String description;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
    @JoinColumn
    private List<Expense> expenseList;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
