package school.faang.amazon_warehouse;

import lombok.ToString;
import lombok.Getter;
import lombok.Setter;
import lombok.RequiredArgsConstructor;

import java.util.Objects;

@ToString
@Getter
@Setter
@RequiredArgsConstructor
public class Product {
    private final int id;
    private final String name;
    private final String category;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Product product = (Product) o;
        return id == product.id && Objects.equals(name, product.name) && Objects.equals(category, product.category);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + Objects.hashCode(name);
        result = 31 * result + Objects.hashCode(category);
        return result;
    }
}
