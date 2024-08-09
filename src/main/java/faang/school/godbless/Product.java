package faang.school.godbless;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode
public class Product {
    private int id;
    private String name;
    private String category;

    @Override
    public String toString() {
        return "Product: id=" + id + ", name='" + name + '\'' + ", category='" + category + '\'';
    }
}
