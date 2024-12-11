package school.faang.s13task45124;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
public class Product {
    private static int idInc = 0;
    private final int id;
    private final String category;
    private final String name;

    public Product(String category, String name) {
        this.id = idInc++;
        this.category = category;
        this.name = name;
    }
}