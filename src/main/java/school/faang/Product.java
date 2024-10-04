package school.faang;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private int id;
    private String name;
    private String category;

    public static Map<String, List<Product>> groupByCategory(Set<Product> productHashSet) {
        Map<String, List<Product>> groupedProductsByCategory = new HashMap<>();
        for (Product product : productHashSet) {
            groupedProductsByCategory.computeIfAbsent(product.category,
                    v -> new ArrayList<>()).add(product);
        }
        return groupedProductsByCategory;
    }

    public void showAllProductInCategory(Map<String, List<Product>> mapForShowing) {
        mapForShowing.forEach((k, v) -> System.out.printf("Категория (%s): " +
                "Продукты (%s)\n", k, v));
    }
}
