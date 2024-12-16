package school.faang.sprint_1.task_43518;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.concurrent.atomic.AtomicInteger;

@Data
@AllArgsConstructor
public class Product {
    private static final AtomicInteger idGenerator = new AtomicInteger(0);
    private int id;
    private String category;
    private String name;

    public Product(String category, String name) {
        this.id = idGenerator.incrementAndGet();
        this.category = category;
        this.name = name;
    }
}
