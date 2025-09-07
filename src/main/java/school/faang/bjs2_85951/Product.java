package school.faang.bjs2_85951;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
@Getter
public class Product {
    private static int id = 0;
    private String name;
    private Category category;

    public Product(String name, Category category) {
        this.name = name;
        this.category = category;
        id++;
    }
}
