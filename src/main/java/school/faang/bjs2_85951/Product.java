package school.faang.bjs2_85951;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode

public class Product {
    private static int id = 0;
    private String name;
    Category category;

    public Product(String name, Category category) {
        this.name = name;
        this.category = category;
        id++;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }
}
