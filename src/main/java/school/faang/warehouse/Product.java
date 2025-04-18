package school.faang.warehouse;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Objects;

@Data
@AllArgsConstructor
public class Product {
    private static int counter = 1;

    private int id;
    private String name;
    private Category category;

    public Product(String name, Category category) {
        counter++;
        this.name = name;
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
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
