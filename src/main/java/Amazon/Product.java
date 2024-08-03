package Amazon;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
@Getter
public class Product {
    private static int ID = 0;

    private int id;
    private String name;
    private String category;

    public Product(String name, String category) {
        this.name = name;
        this.category = category;
        this.id = ++ID;
    }
}
