package school.faang.BJS232297;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
    private final int id;
    private final String name;
    private String category;
}
