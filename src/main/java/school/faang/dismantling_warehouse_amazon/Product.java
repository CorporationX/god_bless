package school.faang.dismantling_warehouse_amazon;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
public class Product {
    private static int count = 0;
    private final int id;
    @Getter
    private final String name;
    @Getter
    private final Category category;

    public Product(String name, Category category) {
        this.id = ++count;
        this.name = name;
        this.category = category;
    }

    @Override
    public String toString() {
        return "- " + name + "\n";
    }
}