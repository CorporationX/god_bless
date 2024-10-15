package school.faang.amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Main {
    private static final HashSet<Product> PRODUCT_HASH_SET = new HashSet<>();
    private static final HashMap<String, List<Product>> GROUPED_PRODUCTS = new HashMap<>();


    public static HashMap<String, List<Product>> groupProductsByCategory(HashSet<Product> hashSet) {
        for (Product product : hashSet) {
            GROUPED_PRODUCTS.computeIfAbsent(product.getCategory(), k -> new ArrayList<>()).add(product);
        }
        return GROUPED_PRODUCTS;
    }

    public static void showAllProductsInCategories() {
        for (Map.Entry<String, List<Product>> entry : GROUPED_PRODUCTS.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        Product product1 = new Product(1, "TV", "A");
        Product product2 = new Product(2, "Computer", "A");
        Product product3 = new Product(3, "Mouse", "A");
        Product product4 = new Product(4, "Cushion", "B");
        Product product5 = new Product(5, "Table", "B");

        PRODUCT_HASH_SET.add(product1);
        PRODUCT_HASH_SET.add(product2);
        PRODUCT_HASH_SET.add(product3);
        PRODUCT_HASH_SET.add(product4);
        PRODUCT_HASH_SET.add(product5);

        groupProductsByCategory(PRODUCT_HASH_SET);
        showAllProductsInCategories();

    }
}
