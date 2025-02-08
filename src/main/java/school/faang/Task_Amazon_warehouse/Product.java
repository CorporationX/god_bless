package school.faang.Task_Amazon_warehouse;

import lombok.Getter;
import lombok.ToString;

import java.util.Objects;

@Getter
@ToString

public class Product {
    private static int idCounter = 1;

    private final int id = idCounter++;
    private String name;
    private Category category;

    public Product(String name, Category category) {
        this.name = name;
        this.category = category;
        validateName(name);
        validateCategory(category);
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
        try {
            if (name.isBlank()) {
                throw new IllegalArgumentException("Ошибка! Имя не может быть пустым");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void validateCategory(Category category) {
        try {
            if (category == null) {
                throw new IllegalArgumentException("Ошибка котигория не должна быть null!");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}