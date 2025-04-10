package school.faang.amazon;

import java.util.*;
import java.util.stream.Collectors;

public class ProductManager {
    private Set<Product> products = new HashSet<>();
    private int productId = 0;

    public void addProduct(Category category, String name) {
        products.add(new Product(++productId, name, category));
    }

    public boolean removeProduct(Category category, String name) {
        return products.removeAll(products.stream()
                .filter(e -> e.getCategory().equals(category) && e.getName().equals(name))
                .collect(Collectors.toSet()));
    }

    public Set<Product> findProductsByCategory(Category category) {
        return products.stream()
                .filter(e -> e.getCategory().equals(category))
                .collect(Collectors.toSet());
    }

    public Map<Category, List<Product>> groupProductsByCategory() {
        Map<Category, List<Product>> mapProductByCategory = new HashMap<>();

        products.forEach(e -> mapProductByCategory.computeIfAbsent(e.getCategory(), k -> new ArrayList<>()).add(e));

        return mapProductByCategory;
    }

    public void printAllProducts() {
        Map<Category, List<Product>> mapProductByCategory = groupProductsByCategory();

        for (Map.Entry<Category, List<Product>> map : mapProductByCategory.entrySet()) {
            System.out.println("Категория: " + map.getKey() + "\nПродукты:");
            for (Product product : map.getValue()) {
                System.out.println(" - " + product.getName());
            }
        }
    }
}
