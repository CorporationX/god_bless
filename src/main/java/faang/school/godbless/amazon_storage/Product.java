package faang.school.godbless.amazon_storage;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
    private long id;
    private String name;
    private String category;

    @Override
    public String toString() {
        return "id: " + id +
                ", name: " + name +
                ", category: " + category;
    }
}
