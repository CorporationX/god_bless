package faang.school.godbless;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class Product {
    private int id;
    private String name;
    private String category;

    Product(int id, String name, String category) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Product name cannot be null or empty");
        }
        if (category == null || category.isEmpty()) {
            throw new IllegalArgumentException("Product category cannot be null or empty");
        }
        this.id = id;
        this.name = name;
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product: id=" + id + ", name='" + name + '\'' + ", category='" + category + '\'';
    }
}
