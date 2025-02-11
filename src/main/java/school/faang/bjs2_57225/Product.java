package school.faang.bjs2_57225;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@Getter
public class Product {
    private static int id;
    private final String name;
    private final Category category;

    public Product(@NonNull String name, @NonNull Category category) {
        id++;
        this.name = name;
        this.category = category;
    }

}
