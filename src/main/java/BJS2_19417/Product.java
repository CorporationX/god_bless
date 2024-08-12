package BJS2_19417;

import lombok.Getter;
import lombok.ToString;

import java.util.Objects;

@ToString
@Getter
public class Product {
    private final int id;
    private final String name;
    private final String category;

    public Product(int id, String name, String category) {
        this.id = id;
        this.name = name;
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id && Objects.equals(name, product.name) && Objects.equals(getCategory(), product.getCategory());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, getCategory());
    }
}
