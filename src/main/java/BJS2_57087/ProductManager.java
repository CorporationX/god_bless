package BJS2_57087;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ProductManager {
    Set<Product> products = new HashSet<>();
    Map<Category, List<Product>> categoryMap = new HashMap<>();
    private int currentId = 1;

    public void addProduct(Category category, String name) {
        Product product = new Product(currentId, name, category);
        if (products.add(product)) {
            categoryMap.computeIfAbsent(category, c -> new ArrayList<>()).add(product);
        } else {
            System.out.println("A product with the name: \"" + product.getName() + "\" already exists");
        }

        currentId++;
    }

    public void removeProduct(Category category, String name) {
        Product product = products.stream()
                .filter(p -> p.getName().equals(name) && p.getCategory().equals(category))
                .findFirst()
                .orElse(null);

        if (product != null) {
            products.remove(product);
            List<Product> categoryProducts = categoryMap.get(category);
            if (categoryProducts != null) {
                categoryProducts.remove(product);
            }
        } else {
            System.out.printf("Product %s not found", name);
        }
    }

    public List<Product> findProductsByCategory(Category category) {
        return categoryMap.get(category);
    }

    public void groupProductsByCategory() {
        categoryMap.clear();
        for (Product product : products) {
            categoryMap.computeIfAbsent(product.getCategory(), c -> new ArrayList<>()).add(product);
        }
    }

    public void printAllProducts() {
        if (categoryMap.isEmpty()) {
            System.out.println("No products found");
            return;
        }

        StringBuilder sb = new StringBuilder();
        categoryMap.forEach((category, products) -> {
            if (!products.isEmpty()) {
                sb.append("Category: ").append(category).append("\n")
                        .append("Products:\n");
                products.forEach(product -> sb.append("- ").append(product.getName()).append("\n"));
                sb.append("\n");
            }
        });
        System.out.print(sb);
    }
}
