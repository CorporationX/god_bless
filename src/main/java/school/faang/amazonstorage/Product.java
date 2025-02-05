package school.faang.amazonstorage;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode
@ToString
@Getter
@Setter
public class Product {
    private static int idCounter = 100;

    private int id;
    private String name;
    private Category category;

    public Product(String name, Category category) {
        this.id = idCounter++;
        this.name = name;
        this.category = category;
    }
}
