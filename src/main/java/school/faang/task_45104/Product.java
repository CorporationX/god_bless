package school.faang.task_45104;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@EqualsAndHashCode
public class Product {
    private int id;
    private String name;
    private String category;
    private static int indx;

    public Product(String name, String category) {
        this.name = name;
        this.category = category;
        indx++;
        this.id = indx;
    }
}
