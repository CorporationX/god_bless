package school.faang.amazon.warehouse;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Product {
    @Getter(AccessLevel.PRIVATE)
    @Setter(AccessLevel.PRIVATE)
    private static int idCounter;
    private final int id;
    private final String name;
    private final Category category;

    public Product(String name, Category category) {
        this.id = ++idCounter;
        this.name = name;
        this.category = category;
    }
}
