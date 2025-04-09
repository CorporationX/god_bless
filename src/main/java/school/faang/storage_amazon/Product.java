package school.faang.storage_amazon;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
public class Product {
    private static long idCounter = 0;

    private final long id;
    private final String name;
    private final Category category;

    public Product(Category category, String name) {
        this.id = idCounter++;
        this.name = name;
        this.category = category;
    }
}
