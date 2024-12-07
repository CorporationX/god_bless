package school.faang.bsj245090;

import lombok.experimental.UtilityClass;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@UtilityClass
public class ProductsListUtils {
    public static Set<Product> products = new HashSet<>();

    public static void addItem(String category, String name) {
        Product product = new Product(category, name);
        products.add(product);
        System.out.println(product + " added to system");
    }

    public static void removeItem(String category, String name) {
        Product product = new Product(category, name);
        products.add(product);
        System.out.println(product + " removed from system");
    }

    public static void findItemsByCategory(String category) {

    }

    public static void printAllItems() {
        products.forEach(System.out::println);
    }

    public static Map<String, List<Product>> groupProductsByCategory() {

        return new HashMap<>();
    }

    public static void printProductsByCategory() {
        products.forEach(System.out::println);
    }
}
