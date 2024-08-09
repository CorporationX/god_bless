package faang.school.godbless.BJS2_19400;

import lombok.Data;

import java.util.Objects;

@Data
public class Product {
    private long id;
    private String name;
    private String category;

    public Product(String name, String category) {
        this.name = name;
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product product)) return false;
        return getId() == product.getId() && Objects.equals(getName(), product.getName()) && Objects.equals(getCategory(), product.getCategory());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getCategory());
    }
}
