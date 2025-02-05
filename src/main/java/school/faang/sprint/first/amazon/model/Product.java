package school.faang.sprint.first.amazon.model;

import lombok.Getter;

import java.util.Objects;

@Getter
public class Product {
    private final int id;
    private final String name;
    private final Category category;

    public Product(String name, Category category) {
        this.id = hashCode();
        this.name = name;
        this.category = category;
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
}
