package school.faang.amazon;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode

public class Product {
    private int id = 1;
    private final String name;
    private final Category category;

    public Product(String name, Category category) {
        id += 1;
        this.name = name;
        this.category = category;
    }
}

