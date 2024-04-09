package faang.school.godbless.BJS2_5141;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ProductsByGroup {
    Map<String, Set<Product>> productsByGroup = new HashMap<>();

    public void toGroupProducts(Set<Product> products) {
        for (Product product : products) {
            productsByGroup.computeIfAbsent(product.getCategory(), k -> new HashSet<>()).add(product);
        }
    }

    public void printAllProductsByGroup() {
        for (Map.Entry<String, Set<Product>> entry : productsByGroup.entrySet()) {
            System.out.println(entry.getKey());
            for (Product product : entry.getValue()) {
                System.out.println(product.toString());
            }
        }
    }
}
