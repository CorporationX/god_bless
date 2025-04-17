package school.faang.bjs2_68731;

import lombok.Data;

@Data
public class Product {
    private final int id;
    private final String name;
    private final Category category;

    public Product(String name, Category category) {
        this.id = (name + category.name()).hashCode();
        this.name = name;
        this.category = category;
    }
}
