package school.faang.bjs2_79904;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
public class Product {
    private int id = 1;
    private final String name;
    private final Category category;


    public Product(String name, Category category) {
        this.id += 1;
        this.name = name;
        this.category = category;
    }
}
