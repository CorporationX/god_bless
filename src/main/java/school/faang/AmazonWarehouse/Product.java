package school.faang.AmazonWarehouse;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Product {

    private static int nextId = 1;
    @EqualsAndHashCode.Exclude
    private final int id;
    @NonNull
    private final String name;
    @NonNull
    private final Category category;

    public Product(String name, Category category) {
        this.id = nextId++;
        this.name = name;
        this.category = category;
    }
}
