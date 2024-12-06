package school.faang.task_45141;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Slf4j
public class Warehouse {
    private final Set<Product> products = new HashSet<>();

    public void addItem(Category category, String name) {
        Product product = new Product(category, name);
        products.add(product);
        log.info("Book was added: " + product);
    }

    public void removeItem(Category category, String name) {
        for (Product product : products) {
            Category currentCategory = product.getCategory();
            String currentName = product.getName();
            if (currentCategory.equals(category) && currentName.equals(name)) {
                products.remove(product);
                log.info("Product: " + product + " was deleted");
                return;
            }
        }
        log.info("There is no product with category: " + category + " and name: " + name);
    }

    public void findItemsByCategory(String category) {
        System.out.println("Products from " + category + " : ");
        for (Product product : products) {
            if (product.getCategory().getTitle().equals(category)) {
                System.out.println(product);
            }
        }
    }

    public void printAllItems() {
        for (Product product : products) {
            System.out.println(product);
        }
    }

    public Map<String, List<Product>> groupProductsByCategory() {
        Map<String, List<Product>> grouped = new HashMap<>();
        for (Product product : products) {
            Category category = product.getCategory();
            grouped.computeIfAbsent(category.getTitle(), (p) -> new ArrayList<>()).add(product);
        }
        return grouped;
    }

    public void printProductsByCategory(Map<String, List<Product>> groupedProducts) {
        for (var category : groupedProducts.entrySet()) {
            List<Product> grouped = category.getValue();
            System.out.println("Category: " + category.getKey());
            for (var product : grouped) {
                System.out.println("Id: " + product.getId() + " Name: " + product.getName() + " ");
            }
            System.out.println();
        }
    }
}