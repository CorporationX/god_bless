package BJS2_57087;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Product {
    private int id;
    private final String name;
    private final Category category;
}
