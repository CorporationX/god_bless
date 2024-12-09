package school.faang.task_43518;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import static school.faang.task_43518.IdGenerator.getNextId;

@Getter
public class Product {
    @EqualsAndHashCode.Include
    private final long id;
    private final String name;
    private final String category;

    public Product(String name, String category) {
        this.id = getNextId();
        this.name = name;
        this.category = category;
    }

    @Override
    public String toString() {
        return name;
    }
}
