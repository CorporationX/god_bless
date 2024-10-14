package school.faang.m1s1.bjs2_32290_amazon;

import lombok.Data;

@Data
public class Product {
    private static int count = 1;
    private final int id;
    private final String name;
    private final String category;

    public Product(String name, String category) {
        this.name = name;
        this.category = category;
        this.id = count++;
    }

}
