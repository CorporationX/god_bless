package school.faang.task56900.service;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Product {
    private static int uniqueId = 1;
    private int id;

    @EqualsAndHashCode.Include
    private String name;
    @EqualsAndHashCode.Include
    private Category category;

    public Product(String name, Category category) {
        this.id = uniqueId++;
        this.name = name;
        this.category = category;
    }
}
