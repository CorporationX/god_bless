package school.faang.sprint.first.amazon.model;

import lombok.Data;

@Data
public class Product {
    private final int id;
    private final String name;
    private final Category category;
}
