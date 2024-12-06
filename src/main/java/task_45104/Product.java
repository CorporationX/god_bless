package task_45104;

import lombok.Getter;
import lombok.ToString;

import java.util.Objects;

@ToString
@Getter
public class Product {
    private int id;
    private String name;
    private String category;
    private static int indx;

    public Product(String name, String category) {
        this.name = name;
        this.category = category;
        indx ++;
        this.id = indx;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name) && Objects.equals(category, product.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, category);
    }
}
