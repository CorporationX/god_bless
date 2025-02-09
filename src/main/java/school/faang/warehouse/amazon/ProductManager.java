package school.faang.warehouse.amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

public class ProductManager {
    private Set<Product> products = new HashSet<>();
    private Map<Category, List<Product>> categoryMap = new HashMap<>();
    private int currentId = 1;

    public void addProduct(Category category, String name) {
        if (!isValidProductAttribute(category, name)) {
            return;
        }
        for (Product product : products) {
            if (product.getCategory().equals(category) && product.getName().equals(name)) {
                System.out.printf("Товар %s из категории %s уже присутствует в базе!\n", name, category);
                return;
            }
        }
        int id = currentId++;
        Product product = new Product(id, category, name);
        products.add(product);
        addProductInGroup(product, categoryMap);
        System.out.printf("Добавлен товар %s категории %s", name, category);
    }

    private boolean isValidProductAttribute(Category category, String name) {
        if (category != null && name != null && !name.isBlank()) {
            return true;
        }
        System.out.printf("Используются не допустимые параметры:\nКатегория - %s; Товар - %s\n", category, name);
        return false;
    }

    public void removeProduct(Category category, String name) {
        if (!isValidProductAttribute(category, name)) {
            return;
        }
        Predicate<Product> condition = product -> (product.getCategory().equals(category)
                && product.getName().equals(name));
        if (products.removeIf(condition)) {
            System.out.printf("Товар %s из категории %s удален\n", name, category);
            return;
        }
        System.out.printf("Не возможно удалить товар %s категории %s: отсутствует в базе.\n", name, category);
    }

    public List<Product> findProductsByCategory(Category category) {
        return categoryMap.getOrDefault(category, new ArrayList<>());
    }

    public void groupProductsByCategory() {
        Map<Category, List<Product>> map = new HashMap<>();
        for (Product product : products) {
            addProductInGroup(product, map);
        }
        categoryMap = map;
    }

    private void addProductInGroup(Product product, Map<Category, List<Product>> map) {
        map.computeIfAbsent(product.getCategory(), k -> new ArrayList<>());
        map.get(product.getCategory()).add(product);
    }

    public void printAllProducts() {
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<Category, List<Product>> entry : categoryMap.entrySet()) {
            builder.append("\nКатегория: ").append(entry.getKey().toString()).append("\nПродукты:");
            for (Product product : entry.getValue()) {
                builder.append("\n- " + product.getName());
            }
        }
        System.out.println(builder);
    }
}
