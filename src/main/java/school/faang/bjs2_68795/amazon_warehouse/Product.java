package school.faang.bjs2_68795.amazon_warehouse;

import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@ToString
@Getter
public class Product {
    private final UUID id;
    private final String name;
    private final Category category;

    public Product(String name, Category category) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.category = category;
    }
}