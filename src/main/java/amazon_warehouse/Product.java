package amazon_warehouse;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Getter
@Setter
@Component
public class Product {
    private static int idCounter = 0;
    private Integer id;
    private String category;
    private String name;

    public Product(String name, String category) {
        this.id = ++idCounter;
        this.category = validatorValue(category);
        this.name = validatorValue(name);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
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

    public String validatorValue(String value) {
        if (value.isBlank()) {
            throw new IllegalArgumentException("поле не может быть пустым!");
        }
        return value.toLowerCase();
    }
}
