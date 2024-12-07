package school.faang.task_45107;

import java.util.Map;
import java.util.Set;
import java.util.List;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Main {
    private static final Set<Product> PRODUCTS = new HashSet<>();
    private static AtomicInteger productCounter = new AtomicInteger(1);

    public static void main(String[] args) {
        addItem(Category.Food.toString(), "Apple");
        addItem(Category.Food.toString(), "Banana");
        addItem(Category.Food.toString(), "Qiwi");
        addItem(Category.Electronics.toString(), "Phone");

        System.out.println(findItemsByCategory("Food"));
        removeItem("Food", "Apple");
        System.out.println(printAllProducts());

        Map<String, List<Product>> groupedMap = groupProductsByCategoryName(PRODUCTS);
        printProductsByCategory(groupedMap);
    }

    public static void addItem(String category, String name) {
        Category categoryTest = Category.compareStrings(category);
        Product request = new Product(productCounter.getAndIncrement(), name, categoryTest);
        PRODUCTS.add(request);
    }

    public static void removeItem(String category, String name) throws IllegalArgumentException {
        Category categoryTest = Category.compareStrings(category);
        if (categoryTest == null) {
            throw new IllegalArgumentException("Category is null!");
        }

        Product request = PRODUCTS.stream()
                .filter(s -> s.category().equals(categoryTest))
                .findFirst()
                .orElseThrow(
                        () -> new IllegalArgumentException("No product founded!")
                );

        if (!PRODUCTS.contains(request)) {
            throw new IllegalArgumentException("The product was not found!");
        }
        PRODUCTS.remove(request);
    }

    public static List<Product> findItemsByCategory(String category) {
        List<Product> productsByCategory = new ArrayList<>();

        Category categoryTest = Category.compareStrings(category);
        if (categoryTest == null) {
            throw new IllegalArgumentException("Category is null!");
        }

        PRODUCTS.stream()
                .filter(s -> s.category().equals(categoryTest))
                .forEach(productsByCategory::add);

        return productsByCategory;
    }

    private static List<Product> printAllProducts() {
        return new ArrayList<>(PRODUCTS);
    }

    public static Map<String, List<Product>> groupProductsByCategoryName(Set<Product> products) {
        if (products.isEmpty()) {
            throw new IllegalArgumentException("Set is empty!");
        }

        return products.stream()
                .collect(Collectors.groupingBy(product -> product.category().toString()));
    }

    public static void printProductsByCategory(Map<String, List<Product>> groupedProducts) {
        if (groupedProducts.isEmpty()) {
            throw new IllegalArgumentException("Map is empty!");
        }

        groupedProducts.forEach(
                (k, v) -> System.out.println(k + " -> " + v)
        );
    }
}
