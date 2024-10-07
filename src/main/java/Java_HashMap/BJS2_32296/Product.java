package Java_HashMap.BJS2_32296;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class Product {
    private int id;
    private String name;
    private String category;

    public Product(int id, String name, String category) {
        this.id = id;
        this.name = name;
        this.category = category;
    }

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
    @Override
    public String toString() {
        return "Product{id=" + id + ", name='" + name + "', category='" + category + "'}";
    }
}
