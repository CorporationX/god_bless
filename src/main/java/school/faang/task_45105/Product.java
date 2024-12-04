package school.faang.task_45105;

import lombok.Data;

import java.util.concurrent.atomic.AtomicInteger;

@Data
public class Product {
    private static AtomicInteger idCounter = new AtomicInteger(1);
    private int id;
    private String name;
    private String category;

    public Product(String name, String category) {
        this.id = idCounter.getAndIncrement();

        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.name = name;

        if (category == null || category.isEmpty()) {
            throw new IllegalArgumentException("Category cannot be null or empty");
        }
        this.category = category;
    }
}
