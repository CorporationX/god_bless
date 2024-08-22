package faang.school.godbless;

import lombok.Getter;
import java.util.List;

@Getter
public class Product {
    private int productId;
    private String name;
    private String category;
    private double price;
    private List<String> tags;

    public Product(int productId, String name, String category, double price, List<String> tags) {
        this.productId = productId;
        this.name = name;
        this.category = category;
        this.price = price;
        this.tags = tags;
    }
}
