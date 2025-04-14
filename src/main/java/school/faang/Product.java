package school.faang;

import lombok.Data;

@Data
public class Product {
    private static int counter = 1;

    private final int id;
    private final String name;
    private final Category category;

    public Product(String name, Category category) {
        this.id = counter++;
        this.name = name;
        this.category = category;
    }

}
