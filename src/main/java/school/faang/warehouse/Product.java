package school.faang.warehouse;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Product {
    private static int id = 0;
    private final Category category;
    private final String name;

    public Product(Category category, String name) {
        id++;
        this.category = category;
        this.name = name;
    }


}
