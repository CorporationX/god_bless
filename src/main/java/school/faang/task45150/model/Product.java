package school.faang.task45150.model;

import lombok.Data;

@Data
public class Product {
    private final Integer id;
    private final String name;
    private final String category;

    public Product(Integer id, String category, String name) {
        this.id = id;
        this.category = category;
        this.name = name;
    }
}
