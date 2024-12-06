package school.faang.task_45141;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

@Slf4j
public class Warehouse {
    private final Set<Product> products = new HashSet<>();

    public void addItem(Product product) {
        products.add(product);
        log.info("Book was added: " + product);
    }

    public void removeItem(Product product) {
        Category categoryToRemove = product.getCategory();
        String nameToRemove = product.getName();

        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product next = iterator.next();
            Category currentCategory = next.getCategory();
            String currentName = next.getName();

            if (currentCategory.equals(categoryToRemove) && currentName.equals(nameToRemove)) {
                iterator.remove();
                log.info("Product deleted: " + product);
                return;
            }
        }
        log.info("There is no product: " + product);
    }

    public void findItemsByCategory(String category) {
        System.out.println("Products from " + category + " : ");

        for (Product product : products) {
            String productCategory = product.getCategory().getTitle();
            if (Objects.equals(productCategory, category)) {
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
            List<Product> productsInCategory = grouped.computeIfAbsent(category.getTitle(), (p) -> new ArrayList<>());
            productsInCategory.add(product);
        }
        return grouped;
    }

    public void printProductsByCategory(Map<String, List<Product>> groupedProducts) {
        for (var category : groupedProducts.entrySet()) {
            List<Product> grouped = category.getValue();
            System.out.println("Category: " + category.getKey());
            for (Product product : grouped) {
                System.out.println("Id: " + product.getId() + " Name: " + product.getName() + " ");
            }
            System.out.println();
        }
    }
}