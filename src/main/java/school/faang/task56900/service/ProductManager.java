package school.faang.task56900.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ProductManager {
    private final Set<Product> products = new HashSet<>();
    private final Map<Category, List<Product>> categoryMap = new HashMap<>();

    public void addProduct(Category category, String name) {
        Product newProduct = new Product(name, category);
        if (products.add(newProduct)) {
            categoryMap.computeIfAbsent(category, k -> new ArrayList<>()).add(newProduct);
        }
    }

    public void removeProduct(Category category, String name) {
        products.removeIf(k -> k.getName().equals(name) && k.getCategory() == category);
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

    public Map<Category, List<Product>> groupProductsByCategory() {
        Map<Category, List<Product>> groupedMap = new HashMap<>();

        for (Map.Entry<Category, List<Product>> entry : categoryMap.entrySet()) {
            Category category = entry.getKey();
            List<Product> productList = entry.getValue();

            for (Product product : productList) {
                groupedMap.computeIfAbsent(category, k -> new ArrayList<>()).add(product);
            }
        }
        categoryMap.clear();
        categoryMap.putAll(groupedMap);
        return categoryMap;
    }

    public void printAllProducts() {
        StringBuilder sb = new StringBuilder();
        Map<Category, List<String>> groupedProducts = new HashMap<>();
        for (Product product : products) {
            groupedProducts.computeIfAbsent(product.getCategory(),
                    k -> new ArrayList<>()).add(product.getName());
        }

        for (Map.Entry<Category, List<String>> entry : groupedProducts.entrySet()) {
            sb.append("Категория: ").append(entry.getKey()).append("\n");
            sb.append("Продукты:\n");
            for (String productName : entry.getValue()) {
                sb.append("- ").append(productName).append("\n");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}