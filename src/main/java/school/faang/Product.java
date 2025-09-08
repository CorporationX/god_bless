package school.faang;

import lombok.Getter;

@Getter
public class Product {
    private Long id;
    private final String name;
    private final Category category;

    public Product(String name, Category category) {
        this.name = name;
        this.category = category;
    }

    public enum Category { FOOD, ELECTRONICS, CLOTHING, OTHER }
}
