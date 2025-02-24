package school.faang.bsj245090;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class ProductsList {
    public static Set<Product> products = new HashSet<>();

    public static void addItem(String category, String name) {
        Product product = new Product(category, name);
        products.add(product);
        System.out.println(product + " added to system");
    }

    public static void removeItem(String category, String name) {
        Set<Product> toRemove = products.stream()
                .filter(product ->
                        Objects.equals(product.getCategory(), category)
                        && Objects.equals(product.getName(), name))
                .collect(Collectors.toSet());

        if (toRemove.isEmpty()) {
            System.out.print("Book: %s could not be removed from category: %s as it is not found in system\r\n");
        } else {
            products.removeAll(toRemove);
            toRemove.forEach(product -> System.out.println(product + " removed from system"));
        }
    }

    public static Set<Product> indItemsByCategory(String category) {
        Set<Product> result = products.stream()
                .filter(product -> Objects.equals(product.getCategory(), category))
                .collect(Collectors.toSet());

        return result;
    }

    public static void printAllItems() {
        System.out.println("Output of goods all goods:");
        products.forEach(System.out::println);
    }

    public static Map<String, List<Product>> groupProductsByCategory() {
        Map<String, List<Product>> result = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory));

        return result;
    }

    public static void printProductsByCategory() {
        System.out.println("Output of goods sorted by category:");
        Map<String, List<Product>> groupedProducts = groupProductsByCategory();

        groupedProducts.forEach((category, products) -> {
            System.out.println("Category: " + category);
            products.forEach(System.out::println);
        });
    }
}
