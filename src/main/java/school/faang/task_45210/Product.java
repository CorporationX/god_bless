package school.faang.task_45210;

import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@ToString
public class Product {
    private static int idCounter = 1;

    private final int id;
    private final String name;
    private final String category;

    public Product(String name, String category) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Product name cannot be null or blank");
        }
        if (category == null || category.isBlank()) {
            throw new IllegalArgumentException("Product category cannot be null or blank");
        }

        this.id = idCounter++;
        this.name = name;
        this.category = category;

        log.info("Created product: {id: {}, name: {}, category: {}}", id, name, category);
    }
}