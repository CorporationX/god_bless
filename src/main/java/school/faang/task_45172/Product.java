package school.faang.task_45172;

import lombok.Data;

@Data
public class Product {
    private static int idCounter = 1;
    private int id;
    private String name;
    private String category;

    public Product(String name, String category) {
        this.id = idCounter++;
        this.name = name;
        this.category = category;
    }
}
