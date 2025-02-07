package school.faang.bjs2_56895;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;


public class ProductManager {
    private final Set<Product> products = new HashSet<>();
    private final Map<Category, List<Product>> categoryMap = new HashMap<>();
    private final AtomicInteger idGenerator = new AtomicInteger();

    public void addProduct(Category category, String name) {
        Product newProduct = new Product(idGenerator.incrementAndGet(), name, category);
        if (products.add(newProduct)) {
            categoryMap.computeIfAbsent(category, k -> new ArrayList<>()).add(newProduct);
        } else {
            System.out.println("A product with the name: \"" + newProduct.getName() + "\" already exists");
        }
    }

    public void removeProduct(Category category, String name) {
        Product product = products.stream()
                .filter(p -> p.getName().equals(name))
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

    public List<Product> findProductByCategory(Category category) {
        return categoryMap.getOrDefault(category, Collections.emptyList());
    }

    public void groupProductsByCategory() {
        categoryMap.clear();
        for (Product product : products) {
            categoryMap.computeIfAbsent(product.getCategory(), k -> new ArrayList<>()).add(product);
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
