package school.faang.amazonwarehouse;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
    private int id;           // Product ID
    private String name;      // Product Name
    private String category;  // Product Category
}
