package faang.school.godbless.BJS2_5141;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ProductsByGroup {
    private final Map<String, List<Product>> productsByCategory = new HashMap<>();

    public void groupProductsByCategory(Set<Product> products) {
        for (Product product : products) {
            productsByCategory.computeIfAbsent(product.getCategory(), k -> new ArrayList<>()).add(product);
        }
    }

    public void printAllProductsByCategory() {
        for (Map.Entry<String, List<Product>> entry : productsByCategory.entrySet()) {
            System.out.println(entry.getKey());
            for (Product product : entry.getValue()) {
                System.out.println(product.toString());
            }
        }
    }
}
