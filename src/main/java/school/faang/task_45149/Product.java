package school.faang.task_45149;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;


@EqualsAndHashCode
@Getter
@ToString
public class Product {
    private static int idProd = 0;
    private int id;
    private String name;
    private String category;

    public Product(String name, String category) {
        this.id = idProd++;
        this.name = name;
        this.category = category;
    }
}
