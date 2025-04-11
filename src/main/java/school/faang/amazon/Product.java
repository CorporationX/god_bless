package school.faang.amazon;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@ToString
@Getter
@EqualsAndHashCode
public class Product {
    private static int id = 0;
    private final String name;
    private final Category category;

    public Product(@NonNull String name, Category category) {
        this.name = name;
        this.category = category;
    }

    public static void setId() {
        id++;
    }
}