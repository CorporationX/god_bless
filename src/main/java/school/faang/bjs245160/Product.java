package school.faang.bjs245160;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@ToString
public class Product {
    private final UUID id;
    private String name;
    private String category;

    public Product(String name, String category) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(getName(), product.getName()) && Objects.equals(getCategory(), product.getCategory());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getCategory());
    }
}
