package school.faangSprint2.t21;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Product {
    private String productId;
    private String name;
    private String category;
    private double price;
    private List<String> tags;
}