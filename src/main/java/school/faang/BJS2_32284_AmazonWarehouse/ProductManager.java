package school.faang.BJS2_32284_AmazonWarehouse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ProductManager {
    public Map<String, List<Product>> getProductsByCategory(Set<Product> products) {
        if (products == null) {
            throw new IllegalArgumentException("Products set can't be null.");
        }
        Map<String, List<Product>> productsByCategory = new HashMap<>();
        products.forEach(
                product -> productsByCategory
                        .computeIfAbsent(product.getCategory(), category -> new ArrayList<>())
                        .add(product)
        );
        return productsByCategory;
    }

    public void printProductsByCategory(Map<String, List<Product>> productsByCategories) {
        if (productsByCategories == null) {
            throw new IllegalArgumentException("productsByCategories can't be null.");
        }
        if (productsByCategories.isEmpty()) {
            System.out.println("There are no products in given map.");
        } else {
            productsByCategories.forEach(
                    (category, products) -> {
                        System.out.println(category + ":");
                        products.forEach(System.out::println);
                    });
        }
    }
}
