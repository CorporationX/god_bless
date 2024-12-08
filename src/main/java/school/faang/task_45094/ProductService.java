package school.faang.task_45094;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProductService {
    private final Map<String, List<Product>> productMap;

    public ProductService(Map<String, List<Product>> productMap) {
        this.productMap = productMap;
    }

    public void addItem(String category, Integer id, String name) {
        try {
            var newProduct = new Product(id, name, category);
            if (productMap != null) {
                productMap.computeIfAbsent(category, k -> new ArrayList<>()).add(newProduct);
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public void removeItem(String category, String name) {
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

    public void findItemsByCategory(String category) {
        List<Product> products = productMap.get(category);
        if (products != null) {
            if (products.isEmpty()) {
                System.out.println("Нет товаров в категории " + category);
            } else {
                System.out.println("Товары в категории " + category
                        + ": " + products.stream().map(Product::getName).collect(Collectors.joining(", ")));
            }
        } else {
            System.out.println("Категория " + category + " не найдена.");
        }
    }

    public void printAllItems() {
        for (Map.Entry<String, List<Product>> entry : productMap.entrySet()) {
            System.out.println("Категория: " + entry.getKey()
                    + ", Товары: " + entry.getValue().stream().map(Product::getName).collect(Collectors.joining(", ")));
        }
    }
}
