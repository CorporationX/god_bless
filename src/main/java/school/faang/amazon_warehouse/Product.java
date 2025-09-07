package school.faang.amazon_warehouse;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class Product {
    public enum Category { FOOD, ELECTRONICS, CLOTHING, OTHER }

    private final Integer id;
    private final String name;
    private final Category category;

    public Product(Integer id, String name, Category category) {
        this.id = id;
        this.name = name;
        this.category = category;
    }
}
