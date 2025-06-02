package school.faang.bjs2_79790;


import lombok.Getter;
import lombok.ToString;

import java.util.Objects;

@ToString
@Getter
public class Product {
    private final int id;
    private final String name;
    private final Category category;

    private static int sequenceId = 1;

    public Product(String name, Category category) {
        this.id = sequenceId++;
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
        int result = Objects.hashCode(name);
        result = 31 * result + Objects.hashCode(category);
        return result;
    }
}
