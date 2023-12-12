package faang.school.godbless.AmazonWarehouse;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Product {
    private int id;
    private String name;
    private String category;

    @Override
    public String toString() {
        return "'" + name + '\'';
    }
}
