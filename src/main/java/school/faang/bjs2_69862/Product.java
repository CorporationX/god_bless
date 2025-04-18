package school.faang.bjs2_69862;

import lombok.Getter;

import java.util.Objects;
import java.util.UUID;

@Getter
public class Product {
    private final UUID id;
    private final String name;
    private final Category category;

    public Product(Category category, String name) {
        this.id = UUID.randomUUID();
        this.category = category;
        this.name = name;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (!(object instanceof Product product)) {
            return false;
        }

        return name.equals(product.name) && category == product.category;
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