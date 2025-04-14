package school.faang.BJS2;

import lombok.Data;

@Data
public class Product {
    private static int counter = 1;

    private final int id;
    private final String name;
    private final school.faang.BJS2.Category category;

    public Product(String name, school.faang.BJS2.Category category) {
        this.id = counter++;
        this.name = name;
        this.category = category;
    }

}