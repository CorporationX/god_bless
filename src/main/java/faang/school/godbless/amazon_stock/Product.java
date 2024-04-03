package faang.school.godbless.amazon_stock;

import lombok.Data;

@Data
public class Product {
    private static int startId = 0;
    private int id;
    private String name;
    private String category;

    public Product(String name, String category) {
        this.id = startId++;
        this.name = name;
        this.category = category;
    }
}
