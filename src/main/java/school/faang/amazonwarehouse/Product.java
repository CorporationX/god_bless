package school.faang.amazonwarehouse;

import java.util.Objects;

public class Product {
    private final int id;
    private static int counter = 0;
    private final String name;
    private final Category category;

    public Product(String name, Category category) {
        this.id = ++counter;
        this.name = name;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    @Override
    public boolean equals(Object o) {
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
}
