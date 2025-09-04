package school.faang;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Product {
    private int id;
    private String name;
    private Category category;

    private static int counter = 0;

    public Product(String name, Category category) {
        this.id = ++counter;
        this.name = name;
        this.category = category;
    }
}
