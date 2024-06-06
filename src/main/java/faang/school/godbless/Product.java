package faang.school.godbless;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.Objects;

@AllArgsConstructor
@Getter
public class Product {
    private int id;
    private String name;
    private String category;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id && Objects.equals(name, product.name) && Objects.equals(category, product.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, category);
    }
}
