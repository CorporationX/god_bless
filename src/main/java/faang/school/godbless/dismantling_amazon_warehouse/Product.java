package faang.school.godbless.dismantling_amazon_warehouse;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Product {
    private UUID id;
    private String name;
    private String category;

    public Product(String name, String category) {
        if (name == null || category == null) {
            throw new IllegalArgumentException("name and category cannot be null");
        }
        if (name.isEmpty() || category.isEmpty()) {
            throw new IllegalArgumentException("name and category cannot be empty");
        }
        this.id = UUID.randomUUID();
        this.name = name;
        this.category = category;
    }
}
