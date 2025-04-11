package school.faang.amazon;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Setter
@Getter
public class Product {
    private int id;
    private String name;
    private Category category;

    public Product(String name, Category category) {
        this.name = name;
        this.category = category;
    }

    public boolean equals(Object otherObject) {
        if (this == otherObject) {
            return true;
        }
        if (otherObject == null || getClass() != otherObject.getClass()) {
            return false;
        }
        Product otherProduct = (Product) otherObject;
        return this.name.equals(otherProduct.getName())
                && this.category.equals(otherProduct.getCategory());
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
