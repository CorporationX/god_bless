package amazon;

import lombok.Data;

import java.util.Random;

@Data
public class Product {

    private int id;
    private String name;
    private String category;

    public Product(String name, String category) {
        this.id = new Random().nextInt(0,100);
        this.name = name;
        this.category = category;
    }
}