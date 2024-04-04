package faang.school.godbless.amazonstorage;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
public class Product {
    private static int idFromBD;

    private final int id;
    private final String name;
    private final String category;

    public Product(String name, String category) {
        this.name = name;
        this.category = category;
        this.id = ++idFromBD;
    }
}
