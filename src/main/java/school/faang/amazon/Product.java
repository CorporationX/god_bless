package school.faang.amazon;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
    private Integer id;
    private String name;
    private String category;
}
