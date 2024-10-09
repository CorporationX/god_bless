package school.faang.BJS2_32285;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class Product {
    private int id;
    private String name;
    private String category;

    public Product(int id, String name, String category) {
        this.id = id;
        this.name = name;
        this.category = category;
    }
}
