package school.faang;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Product {
    private static int nextId = 1;
    private final int id;
    private final String name;
    private final Category category;

    public Product(String name, Category category) {
        this.id = nextId++;
        this.name = name;
        this.category = category;
    }

}
