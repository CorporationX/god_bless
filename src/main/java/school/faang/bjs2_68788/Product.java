package school.faang.bjs2_68788;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode(exclude = "id")
public class Product {
    private static int counter;
    private final int id;
    private final String name;
    private final Category category;

    public Product(String name, Category category) {
        this.id = ++counter;
        this.name = name;
        this.category = category;
    }
}
