package school.faang.task_45107;

import java.util.Map;
import java.util.Set;
import java.util.List;
import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    private static Set<Product> products = new HashSet<>();
    private static AtomicInteger productCounter = new AtomicInteger(1);

    public static void main(String[] args) {
        addItem(Category.Food.toString(), "Apple");
        addItem(Category.Food.toString(), "Banana");
        addItem(Category.Food.toString(), "Qiwi");
        addItem(Category.Electronics.toString(), "Phone");

        System.out.println(findItemsByCategory("Food"));
        removeItem("Food", "Apple");
        System.out.println(printAllItems());

        Map<String, List<Product>> groupedMap = groupProductsByCategory(products);
        printProductsByCategory(groupedMap);
    }

    public static void addItem(String category, String name) {
        Category categoryTest = Category.compareStrings(category);
        Product request = new Product(productCounter.getAndIncrement(), name, categoryTest);
        products.add(request);
    }

    public static void removeItem(String category, String name) throws IllegalArgumentException {
        Category categoryTest = Category.compareStrings(category);
        if (categoryTest == null) {
            throw new IllegalArgumentException("Category is null!");
        }

        Product request = products.stream()
                .filter(s -> s.category().equals(categoryTest))
                .findFirst()
                .orElseThrow(
                        () -> new IllegalArgumentException("No product founded!")
                );

        if (!products.contains(request)) {
            throw new IllegalArgumentException("The product was not found!");
        }
        if (request != null) {
            products.remove(request);
        }
    }

    public static List<Product> findItemsByCategory(String category) {
        List<Product> productsByCategory = new ArrayList<>();

        Category categoryTest = Category.compareStrings(category);
        if (categoryTest == null) {
            throw new IllegalArgumentException("Category is null!");
        }

        products.stream()
                .filter(s -> s.category().equals(categoryTest))
                .forEach(productsByCategory::add);

        if (productsByCategory.isEmpty()) {
            System.out.println("There is no products of that category!");
            return new ArrayList<>();
        }

        return productsByCategory;
    }

    private static List<Product> printAllItems() {
        return new ArrayList<>(products);
    }

    public static Map<String, List<Product>> groupProductsByCategory(Set<Product> products) {
        if (products.isEmpty()) {
            throw new IllegalArgumentException("Set is empty!");
        }

        Map<String, List<Product>> groupedMap = new HashMap<>();
        for (Product product : products) {
            groupedMap.computeIfAbsent(product.category().toString(), (k) -> new ArrayList<>()).add(product);
        }
        return groupedMap;
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
