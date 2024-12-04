package school.faang.task_45102;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Product {
    private static long counter = 1;
    private long id;
    private String name;
    private String category;
    private int quantity;

    public Product(String name, String category, int quantity) {
        this.id = counter++;
        this.name = name;
        this.category = category;
        this.quantity = quantity;
    }
}
