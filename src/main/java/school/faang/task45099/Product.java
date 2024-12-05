package school.faang.task45099;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.Objects;

@Getter
@ToString
@EqualsAndHashCode
public class Product {
    private int id;
    private String name;
    private String category;

    public Product(int id, String name, String category) {
        validate(name, category);

        this.id = id;
        this.name = name;
        this.category = category;
    }

    private static void validate(String name, String category) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be blank");
        }
        if (category == null || category.isBlank()) {
            throw new IllegalArgumentException("Category cannot be blank");
        }
    }
}
