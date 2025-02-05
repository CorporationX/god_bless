package school.faang.sortingamazon;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@AllArgsConstructor
public class ProductManager {
    private static int idCounter = 1;
    private final Set<Product> products = new HashSet<>();
    private final Map<Category, List<Product>> categoryMap = new HashMap<>();

    public void addProduct(Category category, String name) {
        int id = idCounter;
        Product product = new Product(id, name, category);
        if (products.contains(product)) {
            System.out.println("Продукт уже существует.");
            return;
        }

        products.add(product);
        categoryMap.putIfAbsent(category, new ArrayList<>());
        categoryMap.get(category).add(product);
        System.out.println("Продукт успешно добавлен: " + product.toString());
    }

    public void removeProduct(Category category, String name) {
        int id = idCounter;
        Product product = new Product(id, name, category);
        if (!products.contains(product)) {
            System.out.println("Продукт не существует.");
            return;
        }

        categoryMap.get(category).remove(product);
        products.remove(product);
        System.out.println("Продукт успешно удален: " + product.toString());
    }

    public List<Product> findProductsByCategory(Category category) {
        return categoryMap.get(category).stream().toList();
    }

    public void groupProductsByCategory() {
        categoryMap.clear();
        for (Product product : products) {
            Category category = product.getCategory();
            categoryMap.putIfAbsent(category, new ArrayList<Product>());
            categoryMap.get(category).add(product);
        }
    }

    public void printAllProducts() {
        Set<Category> categories = categoryMap.keySet();
        for (Category category : categories) {
            System.out.println("Категория: " + category.toString());
            List<Product> products = categoryMap.get(category);
            System.out.println("Продукты:");
            for (Product product : products) {
                System.out.println(" - " + product.toString());
            }
            System.out.println();
        }
    }
}
