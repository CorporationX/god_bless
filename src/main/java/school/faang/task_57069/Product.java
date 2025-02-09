package school.faang.task_57069;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;

@Getter
@EqualsAndHashCode
public class Product {
    private static int counter = 1;

    private final Integer id;
    private final String name;
    private final Category category;

    public Product(@NonNull String name, @NonNull Category category) {
        this.name = name;
        this.category = category;
        id = counter++;
    }

    public boolean isThisProduct(String name, Category category) {
        return this.getName().equals(name) && this.getCategory().equals(category);
    }

    @Override
    public String toString() {
        return "Продукт{" +
                "id: " + id +
                ", name: " + name +
                ", category: " + category +
                "}";
    }
}
