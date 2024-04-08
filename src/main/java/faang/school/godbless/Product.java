package faang.school.godbless;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
public class Product {
    private int id;
    private String name;
    @Getter
    private String category;

    public Product(int id, String name, String category) {
        this.id = id;
        this.name = name;
        this.category = category;
    }

    @Override
    public String toString() {
        return "(id: " + id + ", name: " + name + ", category: " + category + ")";
    }

    public String getCategory() {
        return category;
    }
}
