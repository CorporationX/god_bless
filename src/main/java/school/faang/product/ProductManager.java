package school.faang.product;

import java.util.*;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

public class ProductManager {
    private final Set<Product> products = new HashSet<>();

    private int count;

    public void add(Category category, String name) {
        count++;
        products.add(new Product(count, name, category));
    }

    public void remove(Category category, String name) {
        products.remove(new Product(count, name, category));
    }

    public List<Product> findByCategory(Category category) {
        return products.stream()
                .filter(product -> product.category().equals(category))
                .collect(toList());
    }

    public Map<Category, List<Product>> groupProductsByCategory() {
        return products.stream()
                .collect(groupingBy(Product::category));
    }

    public void printAll() {
        Map<Category, List<Product>> productsByCategory = groupProductsByCategory();

        for (Map.Entry<Category, List<Product>> entry : productsByCategory.entrySet()) {
            final Category category = entry.getKey();
            final List<Product> products = entry.getValue();
            System.out.println("Category: " + category);

            for (Product product : products) {
                System.out.println(" - " + product.name());
            }

            System.out.println();
        }
    }
}
