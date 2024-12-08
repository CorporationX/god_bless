package school.faang.task_45137;

import lombok.Data;

import java.util.concurrent.atomic.AtomicInteger;

@Data
public class Product {
    private static final AtomicInteger idGenerator = new AtomicInteger(1);
    private final int id;
    private final String name;
    private final String category;

    public Product(String name, String category) {
        this.id = idGenerator.getAndIncrement();
        this.name = name;
        this.category = category;
    }
}