package school.faang.amazonestorage;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Product {
    private final int id;
    private final String name;
    private final Category category;

    @Override
    public String toString() {
        return "Product:" +
                "\nid = " + id +
                ",\nname = '" + name + '\'' +
                ", \ncategory = " + category;
    }
}
