package faang.school.hashmap.amazonwarehouse;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

    private static final Set<Product> gropeProducts = new HashSet<>();

    public static void main(String[] args) {
        Product banana = new Product(1, "Banana", "fruit");
        Product orange = new Product(2, "Orange", "fruit");
        Product apple = new Product(3, "Apple", "fruit");
        Product milk = new Product(4, "Milk", "milky");
        Product bread = new Product(5, "Bread", "bread");

        gropeProducts.addAll(Arrays.asList(banana, orange, apple, milk, bread));


        for (Map.Entry<String, List<Product>> product : groupProductByCategory(gropeProducts).entrySet()) {
            System.out.println(product);
        }
    }

    private static Map<String, List<Product>> groupProductByCategory(Set<Product> products) {
        if (products != null) {
            HashMap<String, List<Product>> gropeProduct = new HashMap<>();
            for (Product product : gropeProducts) {
                gropeProduct.computeIfAbsent(product.getCategory(), k -> new LinkedList<>()).add(product);
            }
            return gropeProduct;
        }
        return null;
    }
}
