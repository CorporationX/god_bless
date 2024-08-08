package faang.school.godbless.BJS2_19401;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
@ToString
@AllArgsConstructor
public class Product {
    private int id;
    private String name;
    private String category;

    public static Map<String, List<Product>> GroupingProductsByCategory(Set<Product> productSet) {
        Map<String, List<Product>> productMap = new HashMap<>();

        for (Product product : productSet) {
            productMap.putIfAbsent(product.category, new ArrayList<>());
            productMap.get(product.category).add(product);
        }
        return productMap;
    }
}
