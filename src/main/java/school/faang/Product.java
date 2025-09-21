package school.faang;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private int id;
    private String name;
    private Category category;

    enum Category {FOOD, ELECTRONICS, CLOTHING, OTHER}
    public  Product(String name, Category category) {
        this.name = name;
        this.category = category;
    }
}
