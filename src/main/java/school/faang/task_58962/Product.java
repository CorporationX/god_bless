package school.faang.task_58962;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
public class Product {
    private final int id;
    private final String name;
    private final Category category;

    public Product(int id, String name, Category category) {
        checkNullName(name);
        this.id = id;
        this.name = name;
        this.category = category;
    }

    private void checkNullName(@NonNull String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Name cant be blank.");
        }
    }
}
