package school.faang.AmazonWarehouse;

import lombok.Getter;

import java.util.Objects;

@Getter
public class Product {
    private static int nextId = 1;
    private final int id;
    private final String name;
    private final Category category;

    public Product(String name, Category category) {
        this.id = nextId++;
        this.name = name;
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Product product = (Product) o;
        return id == product.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return name;
    }
}
