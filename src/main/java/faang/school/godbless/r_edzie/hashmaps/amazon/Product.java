package faang.school.godbless.r_edzie.hashmaps.amazon;

import lombok.Data;

@Data
public class Product {
    private final int id;
    private final String name;
    private final String category;

    public Product(int id, String name, String category) {
        this.id = id;
        this.name = name;
        this.category = category;
    }
}
