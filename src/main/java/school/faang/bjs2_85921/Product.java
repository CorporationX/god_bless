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
    private static final int DEFAULT_ID = 0;
    private String name;
    private Category category;
    private int id = DEFAULT_ID;

    public Product(String name, Category category) {
        this.name = name;
        this.category = category;
    }
}
