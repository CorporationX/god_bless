package faang.school.godbless.BJS2_19472;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
@AllArgsConstructor
public class Product {
    private int id;
    private String name;
    private String category;

    public static Map<String, List<Product>> groupByCategory(Set<Product> products) {
        Map<String, List<Product>> map = new HashMap<>();

        for (Product product : products) {
            List<Product> productList = map.getOrDefault(product.getCategory(), new ArrayList<>());
            productList.add(product);
            map.put(product.getCategory(), productList);
        }

        return map;
    }

    public static void printProducts(Map<String, List<Product>> map) {
        for (Map.Entry<String, List<Product>> entry : map.entrySet()) {
            System.out.printf("Категория: %s, Товары: %s\n", entry.getKey(), entry.getValue());
        }
    }
}
