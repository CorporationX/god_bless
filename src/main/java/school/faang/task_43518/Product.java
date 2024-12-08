package school.faang.task_43518;

import lombok.EqualsAndHashCode;
import lombok.Getter;


@EqualsAndHashCode
@Getter
public class Product {
    private static final IdGenerator ID_GENERATOR = new IdGenerator();
    @EqualsAndHashCode.Include
    private final long id;
    private final String name;
    private final String category;

    public Product(String name, String category) {
        this.id = ID_GENERATOR.getId();
        this.name = name;
        this.category = category;
    }

    @Override
    public String toString() {
        return name;
    }
}
