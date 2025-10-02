package school.faang.bjs2_87126;

import java.util.Objects;

public class Product {
    public int id;
    public String name;
    public Category category;

    public Product(int id, String name, Category category) {
        this.id = id;
        this.name = name;
        this.category = category;
    }

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
        return Objects.hash(id, name, category);
    }
}
