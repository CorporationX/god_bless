package school.faang.bjs2_71088;

import java.util.List;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Product {
    private static int counter = 0;
    private final int productId;
    private String name;
    private String category;
    private double price;
    private List<String> tags;

    public Product(String name, String category, double price, List<String> tags) {
        this.productId = counter++;
        this.name = name;
        this.category = category;
        this.price = price;
        this.tags = tags;
    }

    public Product(int productId, String name, String category, double price, List<String> tags) {
        this.productId = productId;
        this.name = name;
        this.category = category;
        this.price = price;
        this.tags = tags;
    }
}
