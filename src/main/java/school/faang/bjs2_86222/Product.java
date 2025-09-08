package school.faang.bjs2_86222;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
public class Product {

    private final int id;
    private final String name;
    private final Category category;
    private static int nextId = 1;

    public Product(String name, Category category) {
        this.id = nextId++;
        this.name = name;
        this.category = category;
    }
}
