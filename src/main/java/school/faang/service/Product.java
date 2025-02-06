package school.faang.service;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
    private static int uniqueId = 1;
    private int id;
    private String name;
    private Category category;

    public Product(String name, Category category) {
        this.id = uniqueId++;
        this.name = name;
        this.category = category;
    }
}

