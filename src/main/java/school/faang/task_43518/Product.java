package school.faang.task_43518;

import lombok.Getter;

import static school.faang.task_43518.IdGenerator.getNextId;

@Getter
public class Product {
    private final long id;
    private final String name;
    private final Category category;

    public Product(String name, Category category) {
        this.id = getNextId();
        this.name = name;
        this.category = category;
    }

    @Override
    public String toString() {
        return name;
    }
}
