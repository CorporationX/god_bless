package school.faang.amazon_warehouse;

import lombok.ToString;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@ToString
@Getter
@Setter
public class Product {
    private final int id;
    private final String name;
    private final String category;
    private static int idCounter = 0;

    public Product(String name, String category) {
        id = generateId();
        this.name = name;
        this.category = category;
    }

    private int generateId() {
        return ++idCounter;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Product product = (Product) o;
        return Objects.equals(name, product.name) && Objects.equals(category, product.category);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(name);
        result = 31 * result + Objects.hashCode(category);
        return result;
    }
}
