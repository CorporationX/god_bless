package school.faang.bjs2_85921;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@EqualsAndHashCode
@ToString
public class Product {
    private final String name;
    private final Category category;
    private final int id;

    public Product(String name, Category category, int id) {
        this.name = name;
        this.category = category;
        this.id = id;
    }
}
