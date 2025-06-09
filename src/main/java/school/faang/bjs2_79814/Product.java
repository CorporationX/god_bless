package school.faang.bjs2_79814;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(exclude = {"id"})
@AllArgsConstructor
public class Product {
    private final Integer id;
    private final String name;
    private final Category category;

    public Product(String name, Category category) {
        id = null;
        this.name = name;
        this.category = category;
    }
}
