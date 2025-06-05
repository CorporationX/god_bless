package school.faang.dismantling_warehouse_amazon;

import lombok.Getter;
import lombok.ToString;

@ToString
public class Product {
    private int count = 0;
    private final int id;
    @Getter
    private final String name;
    @Getter
    private final Category category;

    public Product(String name, Category category){
        this.id = ++count;
        this.name = name;
        this.category = category;
    }
}