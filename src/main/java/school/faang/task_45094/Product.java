package school.faang.task_45094;

import lombok.Getter;

import java.util.Objects;


@Getter
public class Product {
    private final Integer id;
    private final String name;
    private final String category;

    public Product(Integer id, String name, String category) {
        if (id == null) {
            throw new IllegalArgumentException("id не может быть пустым");
        }
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("name не может быть пустым");
        }
        if (category == null || category.isEmpty()) {
            throw new IllegalArgumentException("category не может быть пустым");
        }

        this.id = id;
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
        return Objects.equals(id, product.id)
                && Objects.equals(name, product.name)
                && Objects.equals(category, product.category);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 41 * result + (id != null ? id.hashCode() : 0);
        result = 43 * result + (name != null ? name.hashCode() : 0);
        result = 47 * result + (category != null ? category.hashCode() : 0);
        return result;
    }
}
