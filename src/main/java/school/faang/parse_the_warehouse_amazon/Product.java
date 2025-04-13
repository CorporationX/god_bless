package school.faang.parse_the_warehouse_amazon;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.Objects;
import java.util.UUID;

@Getter
@EqualsAndHashCode
@ToString
public class Product {
    private final String name;
    private final Category category;
    private final String id;

    public Product(String name, Category category) {
        this.name = Objects.requireNonNull(name, "Product name cannot be null");
        this.category = Objects.requireNonNull(category, "Category cannot be null");
        this.id = UUID.randomUUID().toString();
    }
}
