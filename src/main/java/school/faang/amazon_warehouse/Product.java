package school.faang.amazon_warehouse;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Getter;

@ToString
@Getter
@EqualsAndHashCode
public final class Product {
    private static int idCounter = 1;
    private final int id;
    private final String name;
    private final String category;

    public Product(String name, String category) {
        id = idCounter++;
        this.name = name;
        this.category = category;
    }
}
