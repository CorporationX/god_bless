package school.faang.task45099;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.Objects;

@Getter
@ToString
@EqualsAndHashCode
public class Product {
    private int id;
    private String name;
    private String category;


    public Product(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Product(int id, String name, String category) {
        this(id, name);
        this.category = category;
    }
}
