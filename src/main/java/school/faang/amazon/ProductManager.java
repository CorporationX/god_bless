package school.faang.amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ProductManager {

    private static Set<Product> products = new HashSet<>();
    private static Map<Category, List<Product>> categoryMap = new HashMap<>();

    public void addProduct(Category category, String name) {
        Product product = new Product(name, category);
        for (Product newProduct : products) {
            if (product.getName().equals(name) && product.getCategory().equals(category)) {
                System.out.println("Продукт с именем " + name + " и категорией " + category + " уже существует.");
                return;
            }
        }
        products.add(product);
        categoryMap.putIfAbsent(category, new ArrayList<>());
        categoryMap.get(category).add(product);
    }

    public void removeProduct(Category category, String name) {
        Product newProduct = new Product(name, category);
        if (!products.contains(newProduct)) {
            throw new IllegalArgumentException("Продукт " + newProduct + " отсутствует");
        } else if (!categoryMap.containsKey(category)) {
            throw new IllegalArgumentException("Категория " + category + " отсутствует");
        }
        products.remove(newProduct);
        categoryMap.get(category).remove(newProduct);
    }

    public List<Product> findProductsByCategory(Category category) {
        Product.validateCategory(category);
        return categoryMap.getOrDefault(category, new ArrayList<>());
    }

    public Map<Category, List<Product>> groupProductsByCategory(Set<Product> products) {
        if (products.isEmpty()) {
            return categoryMap;
        }
        for (Product product : products) {
            categoryMap.putIfAbsent(product.getCategory(), new ArrayList<>());
            categoryMap.get(product.getCategory()).add(product);
        }
        return categoryMap;
    }

    public static void printAllProducts() {
        for (Map.Entry<Category, List<Product>> entry : categoryMap.entrySet()) {
            System.out.println("--------");
            System.out.println("Категория :" + entry.getKey());
            for (Product product : entry.getValue()) {
                System.out.println("Продукты :" + product.getName());
            }
        }
    }
}

