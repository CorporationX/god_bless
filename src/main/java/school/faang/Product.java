package school.faang;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class Product {
    private final int id;
    private final String name;
    private final Category category;
    private static int uniqueId = 1;

    private void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name can't be null or blank");
        }
    }

    public Product(Category category, String name) {
        validateName(name);
        this.name = name;
        this.category = category;
        this.id = uniqueId++;
    }
}
