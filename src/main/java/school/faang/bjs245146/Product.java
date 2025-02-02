package school.faang.bjs245146;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
public class Product {
    private static int ID_COUNTER;
    @EqualsAndHashCode.Exclude
    private int id;
    private String name;
    private String category;

    public Product(String name, String category) {
        this.id = ++ID_COUNTER;
        this.name = name;
        this.category = category;
    }
}
