package school.faang.task_45107;

import lombok.Data;

@Data
public class Product {
    private Integer id;
    private String name;
    private Category category;

    public Product(Integer id, String name, Category category) {
        this.id = id;
        this.name = name;
        this.category = category;
    }
}
