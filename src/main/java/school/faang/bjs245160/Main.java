package school.faang.bjs245160;

import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@UtilityClass
public class Main {
    public Map<String, List<Product>> groupProductsByCategory(Set<Product> products) {
        Map<String, List<Product>> productsByCategory = new HashMap<>();
        if (products == null || products.isEmpty()) {
            return productsByCategory;
        }

        products.forEach(product -> productsByCategory.computeIfAbsent(product.getCategory(),
                k -> new ArrayList<>()).add(product)
        );
        return productsByCategory;
    }

    public void printProductsByCategory(Map<String, List<Product>> groupedProducts) {
        groupedProducts.entrySet().forEach(
                entry -> System.out.println("Category: " + entry.getKey() + "Products: " + entry.getValue())
        );
    }
}
