package school.faang.BJS2_32284_AmazonWarehouse;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor
@EqualsAndHashCode
@Getter
public class Product {
    int id;
    String name;
    String category;

    @Override
    public String toString() {
        return String.format("Product with id: %d, category: %s, name: %s", id, category, name);
    }
}
