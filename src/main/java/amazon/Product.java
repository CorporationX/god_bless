package amazon;

import lombok.Data;

import java.util.Random;

@Data
public class Product {

    private static int count = 0;
    private int id;
    private String name;
    private String category;

    public Product(String name, String category) {
        this.id = ++count;
        this.name = name;
        this.category = category;
    }
}