package school.faang;

import lombok.Getter;

import java.util.Objects;

public class Product {
    private final int id;
    @Getter
    private final String name;
    @Getter
    private final Category category;
    private static int uniqueId = 1;

    public enum Category {
        FOOD, ELECTRONICS, CLOTHING, OTHER
    }

    private void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name can't be null or blank");
        }
    }

    public Product(Category category, String name) {
        validateName(name);
        this.name = name;
        this.category = category;
        this.id = uniqueId++;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Product product = (Product) o;
        return Objects.equals(id, product.id) && Objects.equals(name, product.name)
                && Objects.equals(category, product.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, category);
    }
}
