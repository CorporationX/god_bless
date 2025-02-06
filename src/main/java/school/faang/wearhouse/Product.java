package school.faang.wearhouse;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;

@Getter
@EqualsAndHashCode
public class Product {

    private static int nextId = 1;

    private final int id;
    @NonNull
    private final String name;
    private final Category category;

    public Product(@NonNull String name, Category category) {
        this.id = nextId++;
        this.name = name;
        this.category = category;
    }
}
