package faang.school.godbless.javahashmap.amazone;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Store {
    public Map<String, List<Product>> groupProductsByCategory(Set<Product> products) {
        Map<String, List<Product>> productsByCategory = new HashMap<>();
        products.forEach(product -> productsByCategory.computeIfAbsent(
                product.getCategory(), x -> new ArrayList<>()).add(product));
        return productsByCategory;
    }

    public void printGroupedByCategoryProducts(Map<String, List<Product>> groupedProducts) {
        for (Map.Entry<String, List<Product>> entry : groupedProducts.entrySet()) {
            String category = entry.getKey();
            System.out.println("Category: " + category);
            entry.getValue().forEach(product -> System.out.println("    id: " + product.getId() + ", name: " + product.getName()));
        }
    }
}
