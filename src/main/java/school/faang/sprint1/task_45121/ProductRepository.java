package school.faang.sprint1.task_45121;

import lombok.Getter;

import java.util.*;

public class ProductRepository {

    @Getter
    private final Map<String, List<Product>> productsByCategories = new HashMap<>();
    private long nextId = 0;

    public final void addItem(String category, String name) {
        Product product = new Product(nextId++, name, category);
        productsByCategories.computeIfAbsent(category, k -> new ArrayList<>()).add(product);
    }

    public void removeItem(String category, String name) {
        List<Product> products = productsByCategories.get(category);
        if (products != null) {
            products.removeIf(product -> product.getName().equals(name));
        }
    }

    public List<Product> findItemsByCategory(String category) {
        return productsByCategories.get(category);
    }

    public void printAllItems() {
        System.out.println("----- ALL ITEMS -----");
        for (Map.Entry<String, List<Product>> productsByCategoriesEntry : productsByCategories.entrySet()) {
            System.out.printf(
                    "items: %s \n",
                    productsByCategoriesEntry.getValue()
            );
        }
    }
}
