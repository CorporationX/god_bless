package school.faang.BJS232297;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    private static final Map<String, List<Product>> categoryToProductsMap = new HashMap<>();
    private static final Set<Product> setOfProducts = new HashSet<>();

    public Map<String, List<Product>> groupByCategory(Set<Product> products) {
        Map<String, List<Product>> gropedProducts = new HashMap<>();

        for (Product product : products) {
            String category = product.getCategory();
            gropedProducts.computeIfAbsent(category, key -> new ArrayList<>()).add(product);
        }
        return gropedProducts;
    }

    public void printAllCategoryAndProducts() {
        categoryToProductsMap.forEach((category, products) -> {
            System.out.println("Category: " + category);
            products.forEach(product -> System.out.println(" - " + product.getName() + " (ID: " + product.getId() + ")"));
        });
    }
}
