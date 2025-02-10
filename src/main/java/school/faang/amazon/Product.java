package school.faang.amazon;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@Getter
@Setter
@ToString

public class Product {
    private static int idGenerator = 1;
    private long id;
    private String name;
    private Category category;

    public Product(String name, Category category) {
        validateName(name);
        validateCategory(category);
        this.id = idGenerator++; //при создании Product, будет считать счетчик
        this.name = name;
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Product product = (Product) o;
        return Objects.equals(name, product.name) && category == product.category;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, category);
    }

    public static void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Имя ведено не коретно");
        }
    }

    public static void validateCategory(Category category) {
        if (category == null) {
            throw new IllegalArgumentException("Категория не может null");
        }
    }
}


