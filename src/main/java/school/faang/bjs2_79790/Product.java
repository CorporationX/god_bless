package school.faang.bjs2_79790;


import lombok.Getter;
import lombok.ToString;

import java.util.Objects;

@ToString
@Getter
public class Product {
    private final int id;
    private final String name;
    private final ProductCategory productCategory;

    private static int sequenceId = 1;

    public Product(String name, ProductCategory productCategory) {
        this.id = sequenceId++;
        this.name = name;
        this.productCategory = productCategory;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Product product = (Product) o;
        return Objects.equals(name, product.name) && productCategory == product.productCategory;
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(name);
        result = 31 * result + Objects.hashCode(productCategory);
        return result;
    }
}
