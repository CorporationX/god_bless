package school.faang.warehouse_amazon;

import lombok.Data;

@Data
public class Product {
    private static int counterId;

    private int id;
    private String name;
    private String category;

    public Product(String name, String category) {
        this.id = ++counterId;
        this.name = name;
        this.category = category;
    }
}
