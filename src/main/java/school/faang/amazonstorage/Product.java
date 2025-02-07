package school.faang.amazonstorage;

import lombok.Data;

@Data
public class Product {
    private static int idCounter = 100;

    private int id;
    private String name;
    private Category category;

    public Product(String name, Category category) {
        this.id = idCounter++;
        this.name = name;
        this.category = category;
    }
}
