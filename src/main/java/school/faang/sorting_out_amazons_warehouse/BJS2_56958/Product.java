package school.faang.sorting_out_amazons_warehouse.BJS2_56958;

import java.util.Objects;

public record Product(int id, String name, Category category) {

    public Product(String name, Category category) {
        this(0, name, category);
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
