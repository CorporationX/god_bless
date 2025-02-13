package BJS256905;

import lombok.*;

import java.util.Objects;

@Getter
@Setter
@ToString
public class Product {
    private int id;
    private String name;
    private Category category;

    public Product(String name, Category category) {
        this.name = name;
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Product product = (Product) o;
        return Objects.equals(name, product.name)
                && Objects.equals(category, product.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, category);
    }
}