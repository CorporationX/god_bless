package school.faang.bjs2_69862;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Objects;
import java.util.UUID;

@Getter
@EqualsAndHashCode
public class Product {
    private final UUID id;
    private final String name;
    private final Category category;

    public Product(Category category, String name) {
        this.id = UUID.randomUUID();
        this.category = category;
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}