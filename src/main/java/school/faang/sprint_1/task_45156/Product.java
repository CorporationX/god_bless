package school.faang.sprint_1.task_45156;

import lombok.Getter;

import java.util.Objects;

public class Product {
    private static int count = 0;

    private final int id;
    private final String name;
    @Getter
    private final String category;

    public Product(String name, String category) {
        count++;
        id = count;
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
        return Objects.equals(name, product.name) && Objects.equals(category, product.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, category);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
