package school.faang.bjs2_79904;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
public class Product {

    private static int nextId = 1;

    private final int id;
    private final String name;
    private final Category category;


    public Product(String name, Category category) {
        this.id = nextId++;
        this.name = name;
        this.category = category;
    }
}
