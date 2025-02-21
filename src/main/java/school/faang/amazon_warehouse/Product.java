package school.faang.amazon_warehouse;

import java.util.Objects;

public class Product {
    private int id;
    private String name;
    private Category category;

    public enum Category {
        FOOD,
        ELECTRONICS,
        CLOTHING,
        OTHER;
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

    public Product(Category category, String name, int id) {
        this.category = category;
        this.name = name;
        this.id = id;
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
    public String toString() {
        return "id: " + Integer.toString(id) + ", name: " + name + ", category: " + category;
    }
}
