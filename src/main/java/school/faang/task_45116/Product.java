package school.faang.task_45116;

import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class Product {
    private final String id;
    private final String name;
    private final Category category;
}
