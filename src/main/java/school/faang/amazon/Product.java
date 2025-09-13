package school.faang.amazon;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Product {
    private static int idCounter = 0;

    private int id;
    private String name;
    private Category category;

    public Product(String name, Category category) {
        validateInput(name, category);

        this.id = ++idCounter;
        this.name = name;
        this.category = category;
    }

    private void validateInput(String name, Category category) {
        if (name == null || category == null) {
            throw new IllegalArgumentException("Name and category cannot be null.");
        }
    }
}