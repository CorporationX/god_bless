package school.faang.bjs2_79868;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class Product {
    private static int idCounter = 1;

    private int id;
    private String name;
    private Category category;

    public Product(String name, Category category) {
        this.id = idCounter++;
        this.name = name;
        this.category = category;
    }
}
