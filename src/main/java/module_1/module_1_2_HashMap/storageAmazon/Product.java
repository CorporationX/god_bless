package module_1.module_1_2_HashMap.storageAmazon;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
public class Product {
    private static int count = 0;

    private final int id;
    private final String name;
    private final String category;

    public Product(String name, String category) {
        this.id = ++count;
        this.name = name;
        this.category = category;
    }
}
