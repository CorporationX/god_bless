package school.faang;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private Long id;
    private String name;
    private final Category.Categories category;

    public Product(String name, Category.Categories category) {
        this.name = name;
        this.category = category;
    }

}
