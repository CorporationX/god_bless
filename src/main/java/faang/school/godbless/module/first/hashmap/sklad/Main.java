package faang.school.godbless.module.first.hashmap.sklad;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Main {
    private static final HashSet<Product> PRODUCT_SET = new HashSet<>();
    
    public static void main(String[] args) {
        PRODUCT_SET.add(new Product(1, "Noj1", "knife"));
        PRODUCT_SET.add(new Product(2, "Noj2", "knife"));
        PRODUCT_SET.add(new Product(3, "Telephone", "Phone"));
        
        Map<String, List<Product>> categoryToProducts = categorizeByProduct(PRODUCT_SET);
        printProducts(categoryToProducts);
    }
    
    public static Map<String, List<Product>> categorizeByProduct(HashSet<Product> productSet) {
        Map<String, List<Product>> result = new HashMap<>();
        for (Product product : productSet) {
            result.computeIfAbsent(product.getCategory(), value -> new ArrayList<>()).add(product);
        }
        return result;
    }
    
    public static void printProducts(Map<String, List<Product>> products) {
        for (var entry : products.entrySet()) {
            entry.getValue()
                .forEach(product -> System.out.printf(
                    "Product id: %d. Name: %s. Category: %s \n",
                    product.getId(),
                    product.getName(),
                    entry.getKey()
                ));
        }
    }
}
