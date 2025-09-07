package school.faang.bjs2_86222;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.Objects;

@Getter
@ToString
public class Product {

    private final int id;
    private final String name;
    private final Category category;
    private static int nextId = 1;

    public Product(String name, Category category) {
        this.id = nextId++;
        this.name = name;
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name) && category == product.category;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, category);
    }
}
