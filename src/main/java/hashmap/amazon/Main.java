package hashmap.amazon;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Product> productSet = new HashSet<>();
        Product product1 = new Product(1, "smartphone", "electronics");
        Product product2 = new Product(2, "t-shirt", "clothes");
        Product product3 = new Product(3, "smart tv", "electronics");
        Product product4 = new Product(4, "hat", "clothes");
        Product product5 = new Product(5, "aspirin", "medicine");
        productSet.add(product1);
        productSet.add(product2);
        productSet.add(product3);
        productSet.add(product4);
        productSet.add(product5);
        Map<String, List<Product>> categoryMap = createCategoryMap(productSet);
        printCategoryMap(categoryMap);
    }

    public static Map<String, List<Product>> createCategoryMap(@NonNull Set<Product> productSet) {
        Map<String, List<Product>> categoryMap = new HashMap<>();
        for(Product product : productSet) {
            categoryMap.computeIfAbsent(product.getCategory(), v -> new ArrayList<>()).add(product);
        }

        return categoryMap;
    }

    public static void printCategoryMap(@NonNull Map<String, List<Product>> categoryMap) {
        for(Map.Entry<String, List<Product>> category : categoryMap.entrySet()) {
            System.out.println(category.getKey() + ":");
            for(Product product : category.getValue()) {
                System.out.println("    " + product);
            }
        }
    }
}
