package school.faang.task_45138.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Product {
    @ToString.Exclude
    private final UUID id;
    private final String name;
    private final CategoryType category;

    public Product(String name, CategoryType category) {
        this.id = UUID.randomUUID();
        validateName(name);
        this.name = name;
        this.category = category;
    }

    private void validateName(String argument) {
        if (argument == null || argument.isBlank()) {
            throw new IllegalArgumentException("Argument cannot be null or empty");
        }
    }
}
