package school.faang.amazon;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Product {
    private int id;
    private String name;
    private Category category;

    public Product(String name, Category category) {
        this.id = ++id;
        this.name = name;
        this.category = category;
    }
}