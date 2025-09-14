package school.faang.bjs2_86026;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@Getter
public class Product {

    private String name;
    private Category category;
    private int id;

    public Product(String name, Category category, int id) {
        this.name = name;
        this.category = category;
        this.id = id;
    }
}