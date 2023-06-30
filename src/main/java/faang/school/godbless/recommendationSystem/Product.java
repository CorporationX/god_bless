package faang.school.godbless.recommendationSystem;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Product {
    private int productId;
    private String name;
    private String category;
    private double price;
    private List<String> tags;
}
