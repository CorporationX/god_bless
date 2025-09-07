package school.faang.bjs2_85972.product;

import java.util.Objects;

public record Product(int id, String name, Category category) {

    public enum Category {
        FOOD,
        ELECTRONICS,
        CLOTHING,
        OTHER
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Product anotherProduct = (Product) o;
        return name.equalsIgnoreCase(anotherProduct.name) && category == anotherProduct.category;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, category);
    }

    public String toString() {
        return String.format("id[%d]--name[%s]--category[%s]", id, name, category);
    }
}
