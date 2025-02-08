package school.faang.BJS2_56934;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@RequiredArgsConstructor
@EqualsAndHashCode(exclude = {"id"})
@ToString
public class Product {

    private final int id;
    private final String name;
    private final Category category;
    private static int currentId = 1;

    public Product(@NonNull String name, @NonNull Category category) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Заполните название товара");
        }

        this.id = currentId++;
        this.name = name;
        this.category = category;
    }
}
