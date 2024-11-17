package faang.school.godbless.amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Main {

    private final static HashSet<Product> productSet = new HashSet<>();

    public static void main(String[] args) {
        productSet.add(new Product(1, "Product 1", "Category 1"));
        productSet.add(new Product(2, "Product 2", "Category 1"));
        productSet.add(new Product(3, "Product 3", "Category 2"));

        Map<String, List<Product>> categoryToProducts = categorizeByProduct(productSet);

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
                            "product id: %d. name: %s. category: %s \n",
                            product.getId(),
                            product.getName(),
                            entry.getKey()
                    ));
        }
    }

}
