package school.faang.s13task45124;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Product {
    private final long id;
    private final Category category;
    private final String name;

    public Product(Category category, String name) {
        this.id = IdGenerator.generateId();
        this.category = category;
        this.name = name;
    }
}