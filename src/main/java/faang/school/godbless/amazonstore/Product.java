package faang.school.godbless.amazonstore;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Product {
    private int id;

    @Getter
    private String name;

    @Getter
    private String category;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
