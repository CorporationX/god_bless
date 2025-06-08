package school.faang.bjs2_80226;

import lombok.Getter;
import lombok.ToString;

@ToString
public class Product {
    @Getter
    private int id;
    @Getter
    private String name;
    @Getter
    private CategoryEnum category;

    public Product(int id, CategoryEnum category, String name) {
        this.id = id;
        this.name = name;
        this.category = category;
    }
}
