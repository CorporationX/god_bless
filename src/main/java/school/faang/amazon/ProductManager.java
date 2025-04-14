package school.faang.amazon;

import java.util.*;
import java.util.stream.Collectors;

public class ProductManager {
    private Set<Product> products = new HashSet<>();
    private int productId = 0;

    public void addProduct(Category category, String name) {
        products.add(new Product(++productId, name, category));
    }

    public void removeProduct(Category category, String name) {
        products.removeIf(product -> product.getCategory().equals(category) && product.getName().equals(name));
    }

    public Set<Product> findProductsByCategory(Category category) {
        return products.stream()
                .filter(product -> product.getCategory().equals(category))
                .collect(Collectors.toSet());
    }

    public Map<Category, List<Product>> groupProductsByCategory() {
        Map<Category, List<Product>> mapProductByCategory = new HashMap<>();

        products.forEach(product -> mapProductByCategory
                .computeIfAbsent(product.getCategory(), newList -> new ArrayList<>()).add(product));

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
