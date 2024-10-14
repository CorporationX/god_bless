package school.faang.BJS2_35306_RecomendationSystem;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class Product {
    private int productId;
    private String name;
    private String category;
    private double price;
    private List<String> tags;
}
