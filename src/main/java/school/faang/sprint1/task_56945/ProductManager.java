package school.faang.sprint1.task_56945;

import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.UUID;
import java.util.ArrayList;
import java.util.Iterator;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProductManager {
    private final Set<Product> products = new HashSet<>();
    private final Map<Category, List<Product>> categoryMap = new HashMap<>();

    public Product addProduct(Category category, String name) {
        UUID uuid = UUID.randomUUID();
        Product product = new Product(uuid, name, category);

        products.add(product);
        categoryMap.putIfAbsent(category, new ArrayList<>());
        categoryMap.get(category).add(product);
        return product;
    }

    public void removeProduct(Category category, String name) {
        Iterator<Product> iterator = products.iterator();
        boolean productFound = false;

        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getCategory() == category && product.getName().equals(name)) {
                iterator.remove();
                categoryMap.get(category).remove(product);
                productFound = true;
                break;
            }
        }

        if (!productFound) {
            System.out.println("There is no such product or category");
        } else {
            if (categoryMap.get(category).isEmpty()) {
                categoryMap.remove(category);
            }
        }
    }

    public void findProductsByCategory(Category category) {
        List<Product> productsInCategory = categoryMap.get(category);
        if (categoryMap.containsKey(category)) {
            System.out.println("Category: " + category);
            for (Product product : productsInCategory) {
                System.out.println("- " + product.getName());
            }
        } else {
            System.out.println("There is no such category");
        }
    }

    public Map<Category, List<Product>> groupProductsByCategory() {
        Map<Category, List<Product>> productMap = new HashMap<>();
        for (Product product : products) {
            productMap.computeIfAbsent(product.getCategory(), k -> new ArrayList<>()).add(product);
        }
        return productMap;
    }

    public void printAllProducts() {
        for (var entry : categoryMap.entrySet()) {
            List<Product> productsInCategory = entry.getValue();
            System.out.println("Category: " + entry.getKey());
            for (Product product : productsInCategory) {
                System.out.println("- " + product.getName());
            }
            System.out.println();
        }
    }
}
