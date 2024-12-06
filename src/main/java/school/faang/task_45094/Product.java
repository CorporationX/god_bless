package school.faang.task_45094;

import lombok.EqualsAndHashCode;
import lombok.Getter;


@Getter
@EqualsAndHashCode
public class Product {
    private final Integer id;
    private final String name;
    private final String category;

    public Product(Integer id, String name, String category) {
        if (id == null) {
            throw new IllegalArgumentException("id не может быть пустым");
        }
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("name не может быть пустым");
        }
        if (category == null || category.isEmpty()) {
            throw new IllegalArgumentException("category не может быть пустым");
        }

        this.id = id;
        this.name = name;
        this.category = category;
    }
}
