package derschrank.task09.bjstwo_45093;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
public class Product {
    private final static Category DEFAULT_CATEGORY = new Category("with out group");

    private static int maxIdOfProducts = 0;

    private final int id;
    private final String name;

    @Setter
    private Category category;

    public Product(String name) {
        this(++maxIdOfProducts, name);
    }

    public Product(int id, String name) {
        this(id, name, DEFAULT_CATEGORY);
    }

    public Product(int id, String name, Category category) {
        this.id = id;
        this.name = name;
        this.category = category;

        if (id > maxIdOfProducts) {
            maxIdOfProducts = id;
        }
    }

    @Override
    public String toString() {
        return String.format("[%s] Art. %d: %s", category, id, name);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id && Objects.equals(name, product.name) && Objects.equals(category, product.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, category);
    }
}
