package faang.school.godbless.BJS2_19361;

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

    public static Map<String, List<Product>> groupingByCategory(Set<Product> products) {
        Map<String, List<Product>> map = new HashMap<>();

        for (Product product : products) {
            List<Product> count = map.getOrDefault(product.category, new ArrayList<>());
            count.add(product);
            map.put(product.category, count);
        }

        return map;
    }

    public static void printAllProductsByCategory(Map<String, List<Product>> map) {
        for (Map.Entry<String, List<Product>> entry : map.entrySet()) {
            System.out.printf("%s: %s\n", entry.getKey(), entry.getValue());
        }
    }
}
