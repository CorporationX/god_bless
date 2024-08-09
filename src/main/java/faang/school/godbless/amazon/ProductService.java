package faang.school.godbless.amazon;

import java.util.*;

public class ProductService {

    public static HashMap<String, List<Product>> groupProductsByCategory(HashSet<Product> products) {
        HashMap<String, List<Product>> groupedProducts = new HashMap<>();
        for (Product product : products) {
            groupedProducts.computeIfAbsent(product.getCategory(), k -> new ArrayList<>())
                    .add(product);
        }
        return groupedProducts;
    }

    public static void printProducts(HashMap<String, List<Product>> products) {
        for (Map.Entry<String, List<Product>> product : products.entrySet()) {
            System.out.println("Category " + product.getKey());
            System.out.println("Products " + product.getValue());
        }
    }
}
