package faang.school.godbless.javahashmap.amazone;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Store {
    public Map<String, List<Product>> groupProductsByCategory(Set<Product> products) {
        Map<String, List<Product>> groupedProducts = new HashMap<>();

        for (Product product : products) {
            String category = product.getCategory();
            if (groupedProducts.containsKey(category)) {
                groupedProducts.get(category).add(product);
            } else {
                List<Product> productsInCategory = new ArrayList<>();
                productsInCategory.add(product);
                groupedProducts.put(category, productsInCategory);
            }
        }

        return groupedProducts;
    }

    public void printGroupedByCategoryProducts(Map<String, List<Product>> groupedProducts) {
        for (Map.Entry<String, List<Product>> entry : groupedProducts.entrySet()) {
            String category = entry.getKey();
            System.out.println("Category: " + category);
            entry.getValue().forEach(product -> System.out.println("    id: " + product.getId() + ", name: " + product.getName()));
        }
    }
}
