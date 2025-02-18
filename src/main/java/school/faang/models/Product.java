package school.faang.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import school.faang.utils.ValidationUtils;

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
        ValidationUtils.isValidString(name, "Name");
        ValidationUtils.isValidPrice(price);
        ValidationUtils.isValidCategory(category);
        ValidationUtils.isValidList(tags, "tag");

        this.productId = productId;
        this.name = name;
        this.category = category;
        this.price = price;
        this.tags = tags;
    }
}
