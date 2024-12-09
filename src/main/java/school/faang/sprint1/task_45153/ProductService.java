package school.faang.sprint1.task_45153;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ProductService {
    private static final Map<String, List<Product>> PRODUCT_BY_CATEGORY = new HashMap<>();

    public static Map<String, List<Product>> groupProductsByCategory(Set<Product> products) {
        products.forEach((product -> {
            String productCategory = product.getCategory();

            PRODUCT_BY_CATEGORY.computeIfAbsent(productCategory, (value) -> new LinkedList<Product>()).add(product);
        }));
        return (HashMap<String, List<Product>>) PRODUCT_BY_CATEGORY;
    }

    public static boolean addItem(String category, String name) {
        Product product = new Product(name, category);
        PRODUCT_BY_CATEGORY.putIfAbsent(category, new LinkedList<>());
        if (PRODUCT_BY_CATEGORY.get(category).contains(product)) {
            return false;
        }
        PRODUCT_BY_CATEGORY.get(category).add(product);
        return true;
    }

    /**
     * Adds an instance of the Product class to the HashMap.
     * If such an element already exists on the Map in the specified category,
     * it returns false, and if the element was successfully added - true
     */

    public static boolean removeItem(String category, String name) {
        Product product = new Product(name, category);
        return PRODUCT_BY_CATEGORY.containsKey(category) && PRODUCT_BY_CATEGORY.get(category).remove(product);
    }

    /**
     * Removes an instance of the Product class from a HashMap.
     * If such an element is not in the Map in the specified category,
     * returns false, and if the element was successfully removed - true
     */

    public static List<Product> findItemsByCategory(String category) {
        return PRODUCT_BY_CATEGORY.getOrDefault(category, new LinkedList<>());
    }

    public static void printAllItems() {
        for (Map.Entry<String, List<Product>> product : PRODUCT_BY_CATEGORY.entrySet()) {
            System.out.println(product);
        }
    }
}