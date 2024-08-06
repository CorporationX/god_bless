package faang.school.godbless.BJS2_19390;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class Product {
    private static int productIndex = 0;
    private int id;
    private String name;
    private String category;

    public Product(String name, String category) {
        this.id = ++productIndex;
        this.name = name;
        this.category = category;
    }
}
