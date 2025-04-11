package school.faang.amazon;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
    private int id;
    private String name;
    private Category category;
}
