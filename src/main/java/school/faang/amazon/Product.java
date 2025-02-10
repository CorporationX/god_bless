package school.faang.amazon;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@Getter
public class Product {
    private final int id;
    private final String name;
    private final Category category;

    public Product(int id, String name, Category category) {
        this.id = id;
        this.name = name;
        this.category = category;
    }
}