package school.faang.sprint1task45166;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class Wherehouse {
    private int startId;
    private HashSet<Product> productsList;

    public Map<String, List<Product>> groupProductsByCategory(HashSet<Product> products) {
        Map<String, List<Product>> productsByCategory = new HashMap<>();

        for (Product product : products) {
            productsByCategory.computeIfAbsent(product.getCategory(), k -> new ArrayList<>()).add(product);
        }

        return productsByCategory;
    }

    public void printProductsByCategory(Map<String, List<Product>> groupedProducts) {
        for (Map.Entry<String, List<Product>> entry : groupedProducts.entrySet()) {
            System.out.println("Category: " + entry.getKey());
            System.out.println("males: " + entry.getValue());
        }
    }

    public void addItem(String category, String name) {
        Product newProduct = new Product(startId++, category, name);
        productsList.add(newProduct);
    }

    public void removeItem(String category, String name) {
        productsList.removeIf(product -> product.getCategory().equals(category) && product.getName().equals(name));
    }

    public void findItemsByCategory(String category) {
        for (Product product : productsList) {
            if (product.getCategory().equals(category)) {
                System.out.println("product: " + product);
            } else {
                System.out.println("Такая категория не существует: " + category);
            }
        }
    }

    public void printAllItems() {
        for (Product product : productsList) {
            System.out.println(product);
        }
    }
}