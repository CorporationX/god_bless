package school.faang.sprint1.task_BJS2_56911;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@EqualsAndHashCode
@Getter
@ToString
public class Product {
    private static int idGenerator;
    private long id;
    private String name;
    private Category category;

    public Product(Category category, String name) {
        id = idGenerator++;
        this.name = name;
        this.category = category;
    }
}
