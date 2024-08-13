package faang.school.godbless.bjs219615;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ProductManager {
    public static Map<String, List<Product>> groupProductsByCategory(Set<Product> products) {
        Map<String, List<Product>> groupedProducts = new HashMap<>();
        products.forEach(product -> {
            if (groupedProducts.containsKey(product.getCategory())) {
                groupedProducts.computeIfPresent(product.getCategory(), (category, productList) -> {
                    productList.add(product);
                    return productList;
                });
            } else {
                groupedProducts.computeIfAbsent(product.getCategory(), category -> {
                    List<Product> productList = new ArrayList<>();
                    productList.add(product);
                    return productList;
                });
            }
        });
        return groupedProducts;
    }

    public static void printProducts(Map<String, List<Product>> groupedProducts) {
        for(Map.Entry<String, List<Product>> entry : groupedProducts.entrySet()) {
            System.out.print(entry.getKey() + ": ");
            entry.getValue().forEach(product -> System.out.print(product + " "));
            System.out.println();
        }
    }
}
