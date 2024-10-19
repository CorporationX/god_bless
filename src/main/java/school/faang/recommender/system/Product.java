package school.faang.recommender.system;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private int productId;
    private String name;
    private String category;
    private double price;
    private List<String> tags;

    @Override
    public String toString() {
        return name + ":" + category + ":" + price;
    }
}
