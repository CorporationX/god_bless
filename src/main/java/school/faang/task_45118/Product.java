package school.faang.task_45118;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
    private  final int id;
    private final String name;
    private String category;
}
