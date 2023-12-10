package faang.school.godbless.BJS2_697;

import lombok.Data;

@Data
public class Product {
    private static int count;
    private int id;
    private String name;
    private String category;

    public Product(String name, String category) {
        this.id = ++count;
        this.name = name;
        this.category = category;
    }
}
