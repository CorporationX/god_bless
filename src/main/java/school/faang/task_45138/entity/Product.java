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
        if (validation(name)) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.name = name;
        this.category = category;
    }

    private boolean validation(String argument) {
        return argument != null && !argument.isBlank();
    }
}
