package school.faang.bjs2_85972.product;

import lombok.Getter;

import java.util.Objects;

@Getter
public class Product {
    private final int id;
    private final String name;
    private final Category category;

    private static int counter = 0;

    public Product(String name, Category category) {
        this.id = ++counter;
        this.name = name;
        this.category = category;
    }

    public enum Category {
        FOOD,
        ELECTRONICS,
        CLOTHING,
        OTHER
    }

    static void decreaseCounter() {
        counter--;
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
        return "id[" + id + "]--name[" + name + "]--category[" + category + "]";
    }
}
