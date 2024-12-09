package school.faang.bjs_45147;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import school.faang.bjs_45147.enums.Category;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Product {
    private final String name;
    private final Category category;
    private final int id;

    public Product(String name, Category category) {
        this.name = name;
        this.category = category;
        this.id = GeneratorId.createProductId();
    }
}
