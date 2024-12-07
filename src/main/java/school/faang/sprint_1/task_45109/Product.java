package school.faang.sprint_1.task_45109;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.*;

import static school.faang.sprint_1.task_45109.Main.productCategories;

@Getter
@NoArgsConstructor
public class Product {
    private static int counterId = 0;
    int id;
    String name;
    String category;

    public Product(String name, String category) {
        this.id = generateId();
        this.name = name;
        this.category = category;
    }

    private static int generateId() {
        return ++counterId;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id
                + ", name='" + name + '\''
                + ", category='" + category
                + '\'' + '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Product product = (Product) object;
        return Objects.equals(name, product.name) && Objects.equals(category, product.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, category);
    }
}
