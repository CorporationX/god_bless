package school.faang.sprint_1.task_45133;

import lombok.Getter;

import java.util.Objects;

@Getter
public class Product {
    private int id;
    private String name;
    private String category;

    public Product(int id, String name, String category) {
        this.id = id;
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
        if (category.isEmpty()) {
            throw new IllegalArgumentException("Category cannot be empty");
        }
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

    @Override
    public String toString() {
        return "Product id: " + id
                + ", name: '" + name
                + "', category: '"
                + category + '\'';
    }
}