package school.faang.bjs2_68676;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class Product {
    private int id;
    private String name;
    private Category category;
    private static int idCounter = 0;

    public Product(String name, Category category) {
        if (name == null || name.trim().isEmpty()) {
            log.error("Attempted to create Product with invalid name: '{}'", name);
            throw new IllegalArgumentException("Product name cannot be null or empty.");
        }
        this.name = name;
        if (category == null) {
            log.error("Attempted to create Product with invalid category: '{}'", category);
            throw new IllegalArgumentException("Product category cannot be null.");
        }
        this.category = category;
        id = ++idCounter;
    }
}