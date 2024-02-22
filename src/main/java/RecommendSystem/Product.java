package RecommendSystem;

import java.util.List;

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

    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public List<String> getTags() {
        return tags;
    }
}
