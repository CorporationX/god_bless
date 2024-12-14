package school.faang.task_45135;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ProductManager {

    private HashMap<String, HashSet<Product>> categoryMap = new HashMap<>();

    public void addItem(String category, String name) {
        int id = categoryMap.getOrDefault(category, new HashSet<>()).size() + 1;

        Product product = new Product(id, name, category);
        categoryMap.putIfAbsent(category, new HashSet<>());
        categoryMap.get(category).add(product);
    }

    public void removeItem(String category, String name) {
        if (!categoryMap.containsKey(category)) {
            System.out.println("No category found");
            return;
        }

        HashSet<Product> products = categoryMap.get(category);

        if (products.isEmpty()) {
            System.out.println("No items in this category");
            return;
        }

        Product productToRemove = null;
        for (Product product : products) {
            if (product.getName().equals(name)) {
                productToRemove = product;
                break;
            }
        }

        if (productToRemove != null) {
            products.remove(productToRemove);
            System.out.println("Item removed");
        } else {
            System.out.println("No such item in this category");
        }
    }

    public void findItemsByCategory(String category) {
        if (!categoryMap.containsKey(category)) {
            System.out.println("No such category");
            return;
        }

        HashSet<Product> products = categoryMap.get(category);

        if (products.isEmpty()) {
            System.out.println("No items in this category");
            return;
        }

        for (Product product : products) {
            System.out.println(product.getName());
        }
    }


    public void printAllItems() {
        for (String category : categoryMap.keySet()) {
            System.out.println("Category: " + category);

            HashSet<Product> products = categoryMap.get(category);

            if (products.isEmpty()) {
                System.out.println(" No items in this category");
                continue;
            }

            for (Product product : products) {
                System.out.println(" - " + product.getName());
            }
        }
    }

    public HashMap<String, List<Product>> groupProductsByCategory(HashSet<Product> products) {
        HashMap<String, List<Product>> groupedProducts = new HashMap<>();

        for (Product product : products) {
            groupedProducts.putIfAbsent(product.getCategory(), new ArrayList<>());
            groupedProducts.get(product.getCategory()).add(product);
        }
        return groupedProducts;
    }

    public void printProductsByCategory(Map<String, List<Product>> groupedProducts) {
        for (Map.Entry<String, List<Product>> entry : groupedProducts.entrySet()) {
            System.out.println("Category: " + entry.getKey());  // Выводим категорию
            for (Product product : entry.getValue()) {
                System.out.println(" - " + product.getName());  // Выводим товар
            }
        }
    }


    public Set<String> getCategories() {
        return categoryMap.keySet();
    }

    public List<Product> getAllProducts() {
        List<Product> allProducts = new ArrayList<>();
        for (HashSet<Product> products : categoryMap.values()) {
            allProducts.addAll(products);
        }
        return allProducts;
    }
}
