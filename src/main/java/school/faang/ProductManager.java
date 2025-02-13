package school.faang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ProductManager {

    private static int currentId = 0;

    Set<Product> products = new HashSet<>();
    Map<Category, List<Product>> categoryMap = new HashMap<>();

    public void addProduct(Category category, String name) {
        Product product = new Product(currentId++, name, category);
        if (products.contains(product)) {
            throw new IllegalArgumentException(String.format("Продукт: %s уже есть в категории %s", name, category));
        }
        products.add(product);
        categoryMap.computeIfAbsent(category, k -> new ArrayList<>()).add(product);
        System.out.printf("Товар: %s добавлен в категорию: %s \n", name, category);
    }

    public void removeProduct(Category category, String name) {
        List<Product> productList = categoryMap.get(category);
        if (productList != null) {
            productList.removeIf(product -> product.getName().equals(name));
            products.removeIf(product -> product.getName().equals(name));
        }
    }

    public List<Product> findProductsByCategory(Category category) {
        List<Product> listByCategory;
        listByCategory = categoryMap.get(category);
        return listByCategory;
    }

    public void groupProductsByCategory() {
        categoryMap.clear();
        for (Product product : products) {
            categoryMap.computeIfAbsent(product.getCategory(), k -> new ArrayList<>()).add(product);
        }
    }

    public void printAllProducts() {
        for (var entry : categoryMap.entrySet()) {
            System.out.printf("Категория: %s \n", entry.getKey());
            System.out.println("Продукты:");
            entry.getValue().forEach(System.out::println);
        }
    }
}

