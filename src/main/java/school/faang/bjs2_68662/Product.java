package school.faang.bjs2_68662;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Getter
    private static int id = 0;
    private String name;
    Category category;

    public Product(int id, String name, Category category) {
        Product.id = id;
        this.name = name;
        this.category = category;
    }
}
