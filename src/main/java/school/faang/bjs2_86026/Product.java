package school.faang.bjs2_86026;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@Getter
public class Product {

    private static int itter;
    private String name;
    private Category category;
    private int id;

    public Product(String name, Category category) {
        this.name = name;
        this.category = category;
        id = itter++;
    }
}