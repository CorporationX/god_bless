package school.faang.amazon;

import lombok.Data;

@Data
public class Product {

    private int id;

    private String name;

    private Category category;

    public Product(String name, Category category) {
        this.name = name;
        this.category = category;
    }
}
