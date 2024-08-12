package faang.school.godbless.BJS2_19294;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Product {
    private int id;
    private String name;
    private String category;

    @Override
    public String toString() {
        return "Product " +
                "id: " + id +
                ", name: " + name +
                ", category: " + category;
    }
}
