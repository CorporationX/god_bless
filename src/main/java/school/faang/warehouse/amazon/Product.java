package school.faang.warehouse.amazon;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
public class Product {
    private int id;
    private String name;
    private Category category;

    public Product(int id, Category category, String name) {
        this.id = id;
        this.category = category;
        this.name = name;
    }
}
