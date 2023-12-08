package faang.school.godbless.javahashmap.task7;

import lombok.Data;

@Data
public class Product {
    private int id;
    private String name;
    private String category;
    private static int count = 0;

    public Product(String name, String category) {
        this.id = ++count;
        this.name = name;
        this.category = category;
    }
}

