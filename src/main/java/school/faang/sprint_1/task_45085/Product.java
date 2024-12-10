package school.faang.sprint_1.task_45085;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@EqualsAndHashCode
@ToString
@Getter
public class Product {
    private static int idCounter = 0;

    private final int id;
    private final String name;
    private final String category;

    public Product(String name, String category) {
        this.id = idCounter++;
        this.name = name;
        this.category = category;
    }
}
