package school.faang.amazon;

import lombok.Getter;
import lombok.ToString;

import java.util.Objects;

@Getter
public class Product {
    private static int count = 1;
    private int id;
    private String name;
    private Category category;

    public Product(String name, Category category) {
        this.name = name;
        this.category = category;
        id = count++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Product product = (Product) o;
        return Objects.equals(name, product.name) && category == product.category;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, category);
    }

    @Override
    public String toString() {
        return name;
    }
}
