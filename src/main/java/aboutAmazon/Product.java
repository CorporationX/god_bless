package aboutAmazon;

import lombok.Value;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Value
public class Product {
    int id;
    String name;
    String category;

    public static Map<String, List<Product>> groupProductsByCategory(Set<Product> productSet) {
        Map<String, List<Product>> categoriesAndProducts = new HashMap<>();
        for (Product elem : productSet) {
            if (!categoriesAndProducts.containsKey(elem.category)) {
                categoriesAndProducts.put(elem.category, new ArrayList<>());
            }
            categoriesAndProducts.get(elem.category).add(elem);
        }
        return categoriesAndProducts;
    }

    public static void printCategoriesAndProducts(Map<String, List<Product>> stringListMap) {
        for (Map.Entry<String, List<Product>> entry : stringListMap.entrySet()) {
            System.out.print(entry.getKey() + ": ");
            for (Product product : entry.getValue()) {
                System.out.print(product + " ");
            }
            System.out.println();
        }
    }
}
