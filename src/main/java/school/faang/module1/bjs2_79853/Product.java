package school.faang.module1.bjs2_79853;

import lombok.Data;

@Data
public class Product {

    private final int id;
    private final String name;
    private final Category category;
    private static int counter = 1;

    public Product(String name, Category category) {
        this.id = counter++;
        this.name = name;
        this.category = category;
    }
}
