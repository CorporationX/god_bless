package school.faang.task_45167;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@AllArgsConstructor
@Data
public class Product {
    private UUID id;
    private String name;
    private String category;

    public Product(String category, String name) {
        this.id = UUID.randomUUID();
        this.category = category;
        this.name = name;
    }
}