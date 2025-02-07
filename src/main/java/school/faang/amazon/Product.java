package school.faang.amazon;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private static int idGenerator;
    private long id;
    private String name;
    private Category category;

    public Product(String name, Category category) {
        this.id = idGenerator++; //при создании Product, будет считать счетчик
        this.name = name;
        this.category = category;
    }
}


