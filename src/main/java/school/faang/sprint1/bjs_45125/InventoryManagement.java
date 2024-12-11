package school.faang.sprint1.bjs_45125;

import com.github.javafaker.Faker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class InventoryManagement {
    private final Set<Product> products = new HashSet<>();
    private final Map<String, Set<Product>> productsByCategory = new HashMap<>();
    private static final Logger logs = LoggerFactory.getLogger(InventoryManagement.class);
    private final Faker faker = new Faker();

    public int generateProductId() {
        return faker.number().numberBetween(1, 200);
    }

    public boolean checkCategoryAndName(String name, String category) {
        return (name != null) && (category != null);
    }

    public void addItem(String name, String category) {
        if (checkCategoryAndName(name, category)) {
            Product item = new Product(generateProductId(), name, category);
            productsByCategory.computeIfAbsent(category, key -> new HashSet<>())
                    .add(item);
            products.add(item);
        }
    }

    public void removeItem(String name, String category) {
        if (checkCategoryAndName(name, category)) {
            boolean wasRemoved = products.removeIf(product -> name.equals(product.name()));
            if (wasRemoved) {
                var categoryProducts = productsByCategory.get(category);
                if (categoryProducts != null) {
                    categoryProducts.removeIf(product -> name.equals(product.name()));
                }
            } else {
                logs.warn("Product not found");
            }
        }
    }

    public Set<Product> findItemsByCategory(String category) {
        Set<Product> result = new HashSet<>();
        if (category == null) {
            logs.warn("Not valid data");
        } else {
            if (!productsByCategory.containsKey(category)) {
                logs.warn("Category not found");
            } else {
                printItemsByCategory(category);
                result = productsByCategory.get(category);
            }
        }
        return result;
    }

    public void printItemsByCategory(String category) {
        System.out.printf("Category '%s' has items: ", category);
        productsByCategory.get(category).forEach((prod) -> System.out.print(prod.name() + ", "));
    }

    public void printAllItems() {
        for (Map.Entry<String, Set<Product>> categoryList : productsByCategory.entrySet()) {
            printItemsByCategory(categoryList.getKey());
            System.out.println();
        }
    }

    public Map<String, Set<Product>> groupProductsByCategory(Set<Product> products) {
        HashMap<String, Set<Product>> groupedProducts = new HashMap<>();
        products.forEach(product -> groupedProducts.computeIfAbsent(product.category(), value -> new HashSet<>())
                .add(product));
        return groupedProducts;
    }

    public void printProductsByCategory(Map<String, Set<Product>> groupedProducts) {
        System.out.println("List by category:");
        for (Map.Entry<String, Set<Product>> categoryList : groupedProducts.entrySet()) {
            printItemsByCategory(categoryList.getKey());
            System.out.println();
        }
    }
}
