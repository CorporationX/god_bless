package school.faang.dismantling_an_amazon_warehouse;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
public class Product {

    private final int id;
    private final String name;
    private final Category category;
    private int currentId = 1;

    public Product(@NonNull String name, @NonNull Category category) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Заполните название товара");
        }

        this.id = currentId++;
        this.name = name;
        this.category = category;
    }
}
