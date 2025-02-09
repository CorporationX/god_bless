package school.faang.sorting_out_amazons_warehouse.BJS2_56958;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;

@Getter
@EqualsAndHashCode
public class Product {
    private static int nextId = 1;

    private final int id;
    private final String name;
    private final Category category;

    public Product(@NonNull String name, @NonNull Category category) {
        this.id = nextId++;
        this.name = name;
        this.category = category;
    }
}
