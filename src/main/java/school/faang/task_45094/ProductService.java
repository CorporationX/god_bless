package school.faang.task_45094;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProductService {
    public static void addItem(Map<String, List<Product>> productMap, String category, Integer id, String name) {
        try {
            var newProduct = new Product(id, name, category);
            if (productMap != null) {
                productMap.computeIfAbsent(category, k -> new ArrayList<>()).add(newProduct);
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public static void removeItem(Map<String, List<Product>> productMap, String category, String name) {
        List<Product> products = productMap.get(category);
        if (products != null) {
            boolean removed = products.removeIf(product -> product.getName().equals(name));
            if (removed) {
                System.out.println("Товар " + name + " из категории " + category + " удален.");
            } else {
                System.out.println("Товар " + name + " в категории " + category + " не найден.");
            }
        } else {
            System.out.println("Категория " + category + " не найдена.");
        }
    }

    public static void findItemsByCategory(Map<String, List<Product>> productMap, String category) {
        List<Product> products = productMap.get(category);
        if (products != null) {
            if (products.isEmpty()) {
                System.out.println("Нет товаров в категории " + category);
            } else {
                System.out.println("Товары в категории " + category + ": " + products.stream().map(Product::getName).collect(Collectors.joining(", ")));
            }
        } else {
            System.out.println("Категория " + category + " не найдена.");
        }
    }

    public static void printAllItems(Map<String, List<Product>> productMap) {
        for (Map.Entry<String, List<Product>> entry : productMap.entrySet()) {
            System.out.println("Категория: " + entry.getKey() + ", Товары: " + entry.getValue().stream().map(Product::getName).collect(Collectors.joining(", ")));
        }
    }
}
