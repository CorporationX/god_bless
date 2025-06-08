package school.faang.warehouse;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Product {
    private final int id;
    private final Category category;
    private final String name;

    public Product(Category category, String name, int id) {
        this.category = category;
        this.name = name;
        this.id = id;
    }


}
