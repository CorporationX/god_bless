package school.faang;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Product {
    private static int nextId = 1;
    private final int id;
    private final String name;
    private final Category category;

    public Product(String name, Category category) {
        validateName(name);
        this.id = nextId++;
        this.name = name;
        this.category = category;
    }

    private void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name can't be null or blank!");
        }
    }
}