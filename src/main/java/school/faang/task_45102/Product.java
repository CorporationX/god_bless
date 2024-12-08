package school.faang.task_45102;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
public class Product {
    private static long counter = 1;
    private long id;
    private String name;
    private String category;

    public Product(String name, String category) {
        this.id = counter++;
        this.name = name;
        this.category = category;
    }
}
