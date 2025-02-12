package school.faang.task_57215;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
public class Product {
    private static int counter = 1;
    private final int id;
    private final String name;
    private final Category category;

    public Product(String name, Category category) {
        this.id = counter++;
        this.name = name;
        this.category = category;
    }
}
