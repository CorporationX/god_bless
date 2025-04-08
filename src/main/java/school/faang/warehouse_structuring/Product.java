package school.faang.warehouse_structuring;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
    private int id;
    private String name;
    private Category category;
}
