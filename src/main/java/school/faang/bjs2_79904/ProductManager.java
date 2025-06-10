package school.faang.bjs2_79904;

import java.util.*;
import java.util.stream.Collectors;

public class ProductManager {
    private Set<Product> products =  new HashSet<>();

    public void addProduct(Category category, String name) {
        Product product = new Product(name, category);
        products.add(product);

    }

    public boolean removeProduct(Category category, String name) {
        return products.removeIf(p -> p.getCategory() == category && p.getName().equals(name));
    }

    public List<Product> findProductByCategory(Category category) {
        return products.stream()
                .filter(p -> p.getCategory() == category)
                .collect(Collectors.toList());
    }

    public Map<Category, List<Product>> groupProductsByCategory() {
        return products.stream()
                .collect(Collectors.groupingBy(Product::getCategory));
    }

    public void printAllProducts() {
        Map<Category, List<Product>> groupedProducts = groupProductsByCategory();
        for (Map.Entry<Category, List<Product>> entry : groupedProducts.entrySet()) {
            System.out.println("Категория: " + entry.getKey());
            for (Product product : entry.getValue()) {
                System.out.println("- " + product.getName());
            }
        }
    }
}
