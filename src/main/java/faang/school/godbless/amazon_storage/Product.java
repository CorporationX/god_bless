package faang.school.godbless.amazon_storage;

import lombok.Data;

@Data
public class Product {
    private static long productId = 0;
    private long id;
    private String name;
    private String category;

    public Product(String name, String category) {
        productId++;
        this.id = productId;
        this.name = name;
        this.category = category;
    }

    @Override
    public String toString() {
        return "id: " + id +
                ", name: " + name +
                ", category: " + category;
    }
}
