package school.faang.amazon_warehouse;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Getter;
import lombok.Setter;

@ToString
@Getter
@Setter
@EqualsAndHashCode
public final class Product {
    private int id;
    private final String name;
    private final String category;

    public Product(String name, String category) {
        idGenerator();
        this.name = name;
        this.category = category;
    }

    private int idGenerator() {
        this.id = id++;
        return this.id;
    }
}
