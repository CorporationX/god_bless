package school.faang.task56900.service;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
public class ProductManager {
    private Set<Product> products = new HashSet<>();
    private Map<Category, List<String>> categoryMap = new HashMap<>();

    public void addProduct(Category category, String name) {
        products.add(new Product(name, category));
        categoryMap.computeIfAbsent(category, k -> new ArrayList<>()).add(name);
    }

    public void removeProduct(Category category, String name) {
        products.removeIf(k -> k.getName().equals(name) && k.getCategory() == category);

        if (categoryMap.containsKey(category)) {
            List<String> newList = categoryMap.get(category);
            newList.remove(name);
            if (newList.isEmpty()) {
                categoryMap.remove(category);
            }
        }
    }

    public Set<Product> findProductsByCategory(Category category) {
        Set<Product> result = new HashSet<>();
        for (Product value : products) {
            if (value.getCategory() == category) {
                result.add(value);
            }
        }
        return result;
    }

    public Map<Category, List<Product>> groupProductsByCategory(Set<Product> products) {
        Map<Category, List<Product>> productMap = new HashMap<>();
        for (Product product : products) {
            if (!productMap.containsKey(product.getCategory())) {
                productMap.put(product.getCategory(), new ArrayList<>());
            }
            productMap.get(product.getCategory()).add(product);
        }
        return productMap;
    }

    public static void printProductsByCategory(Map<Category, List<Product>> groupedProducts) {
        for (Map.Entry<Category, List<Product>> entry : groupedProducts.entrySet()) {
            System.out.println("Категория: " + entry.getKey());
            for (Product product : entry.getValue()) {
                System.out.println("  - " + product.getName());
            }
        }
    }

    public void printAllProducts() {
        for (Product value : products) {
            System.out.println("Категория: " + value.getCategory() + ", Продукт: " + value.getName());
        }
    }
}
