package faang.school.godbless.RecomendationSystem;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Product {

    private int productId;

    private String name;

    private String category;

    private int price;

    private List<String> tags;
}
