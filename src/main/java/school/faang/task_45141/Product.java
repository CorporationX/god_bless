package school.faang.task_45141;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@EqualsAndHashCode
@ToString
@Getter
public class Product {
    private static final IdGenerator idGenerator = new IdGenerator();

    private final int id;
    private final String name;
    private final Category category;

    public Product(@NonNull Category category, @NonNull String name) {
        this.id = idGenerator.nextId();
        this.category = category;
        this.name = name;
    }
}

