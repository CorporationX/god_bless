package school.faang.naughtwoBSS256996;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
@Getter
public class Product {
    private final int id;
    private final String name;
    private final Category category;

    public Product(int id, String name, Category category) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Incorrect data entered");
        }
        this.id = id;
        this.name = name;
        this.category = category;
    }
}
