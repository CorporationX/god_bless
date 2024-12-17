package school.faang.task_45102;

import java.util.*;

public class ProductRepository {
    private Map<String, Set<Product>> productsByCategory = new HashMap<>();

    public void addItem(String category, String name) {
        Product product = new Product(name, category);
        productsByCategory.computeIfAbsent(category, k -> new HashSet<>()).add(product);
    }

    public void removeItem(String category, String name) {
        if (productsByCategory.containsKey(category)) {
            Set<Product> products = productsByCategory.get(category);
            Iterator<Product> iterator = products.iterator();
            boolean success = false;
            while (iterator.hasNext()) {
                Product product = iterator.next();
                if (Objects.equals(product.getName(), name)) {
                    iterator.remove();
                    success = true;
                }
            }
            if (!success) {
                System.out.println("Unable to delete. Product not found");
            }
        } else {
            System.out.println("category not found");
        }
    }

    public Set<Product> findItemsByCategory(String category) {
        return Optional.ofNullable(productsByCategory.get(category)).orElseThrow(
                () -> new IllegalArgumentException("category not found"));
    }

    public void printAllItems() {
        Collection<Set<Product>> values = productsByCategory.values();
        for (Set<Product> set : values) {
            for (Product p : set) {
                System.out.println(p);
            }
        }
    }
}