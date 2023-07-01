package faang.school;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Product {
    private int productId;
    private String name;
    private String category;
    private double price;
    private List<String> tags;
}
