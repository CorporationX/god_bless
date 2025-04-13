package school.faang.amazon;

import lombok.Data;

@Data
public class Product {
    private final int id;
    private final String name;
    private final Category category;
}
