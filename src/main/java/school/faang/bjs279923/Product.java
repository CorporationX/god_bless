package school.faang.bjs279923;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import java.util.Objects;

@AllArgsConstructor
@Getter
@ToString
public class Product {
    private int id;
    private String name;
    private Category category;

    public Product(String name, Category category) {
        this.name = name;
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Product p)) {
            return false;
        }
        return Objects.equals(name, p.name)
                && Objects.equals(category, p.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, category);
    }
}
