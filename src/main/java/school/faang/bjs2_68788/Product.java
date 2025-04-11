package school.faang.bjs2_68788;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class Product {
    @EqualsAndHashCode.Exclude
    private int id;
    private final String name;
    private final Category category;
    private static int counter;

    public Product(String name, Category category) {
        this.id = ++counter;
        this.name = name;
        this.category = category;
    }
}
