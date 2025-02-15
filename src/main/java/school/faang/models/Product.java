package school.faang.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@EqualsAndHashCode
@ToString
public class Product {
    private final int productId;
    private final String name;
    private final Category category;
    private final int price;
    private final List<String> tags;

    public Product(int productId, String name, Category category, int price, List<String> tags) {
        validateName(name);
        validatePrice(price);
        validateCategory(category);
        validateTags(tags);

        this.productId = productId;
        this.name = name;
        this.category = category;
        this.price = price;
        this.tags = tags;
    }

    private void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("The name can't be null or blank.");
        }
    }

    private void validatePrice(int price) {
        if (price <= 0) {
            throw new IllegalArgumentException("The price must be greater than zero.");
        }
    }

    private void validateCategory(Category category) {
        if (category == null) {
            throw new IllegalArgumentException("The category can't be null.");
        }
    }

    private void validateTags(List<String> tags) {
        if (tags == null || tags.isEmpty()) {
            throw new IllegalArgumentException("The tags can't be null or empty.");
        }
    }
}
