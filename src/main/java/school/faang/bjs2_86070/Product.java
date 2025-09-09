package school.faang.bjs2_86070;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode
@Getter
@Setter
@ToString
public class Product {
    private static int id;
    private String name;
    private Category category;

    public Product(Category category, String name) {
        this.id = id++;
        this.name = name;
        this.category = category;
    }
}
