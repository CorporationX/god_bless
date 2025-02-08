package school.faang.task_57021;

import lombok.Getter;
import java.util.Objects;

@Getter
public class Product {
    private static int staticId = 0;
    private int id;
    private String name;
    private Category category;

    public Product(String name, Category category) {
        this.id = ++staticId;
        this.name = name;
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Product product = (Product) o;
        return id == product.id && Objects.equals(name, product.name) && category == product.category;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, category);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category=" + category +
                '}';
    }
}
