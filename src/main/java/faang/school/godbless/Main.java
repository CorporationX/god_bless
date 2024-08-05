package faang.school.godbless;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        Set<Product> productSet = new HashSet<>();
        Product product1 = new Product(1, "TV", "Tech");
        Product product2 = new Product(2, "PS5", "Tech");
        Product product3 = new Product(3, "Xbox", "Tech");
        Product product4 = new Product(4, "Toyota Corolla", "Car");
        Product product5 = new Product(5, "T-short", "Clothes");

        productSet.add(product1);
        productSet.add(product2);
        productSet.add(product3);
        productSet.add(product4);
        productSet.add(product5);

        Map<String, List<Product>> products = groupProductByCategory(productSet);

        printProductsInfo(products);

    }

    private static Map<String, List<Product>> groupProductByCategory(Set<Product> productSet) {
        Map<String, List<Product>> result = new HashMap<>();
        for (Product product : productSet) {
            result.putIfAbsent(product.getCategory(), new ArrayList<>());
            result.get(product.getCategory()).add(product);
        }
        return result;
    }

    private static void printProductsInfo(Map<String, List<Product>> productMap) {
        for (Map.Entry<String, List<Product>> entry : productMap.entrySet()) {
            System.out.println("Category: " + entry.getKey() + ", Products: " + entry.getValue());
        }
    }
}
