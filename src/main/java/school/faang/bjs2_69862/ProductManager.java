package school.faang.bjs2_69862;

import java.util.*;
import java.util.stream.Collectors;

public class ProductManager {
    private final Set<Product> products = new HashSet<>();

    public void addProduct(Category category, String name) {
        var product = new Product(category, name);
        products.add(product);
    }

    public void removeProduct(Category category, String name) {
        Product productToRemove = null;
        for (var product : products) {
            if (product.getCategory() == category && product.getName().equals(name)) {
                productToRemove = product;
                break;
            }
        }

        if (productToRemove == null) {
            System.out.println("Продукт не найден: " + name + ", " + category);
            return;
        }

        products.remove(productToRemove);
    }

    public List<Product> findProductsByCategory(Category category) {
        return products.stream()
                .filter(p -> p.getCategory() == category)
                .collect(Collectors.toList());
    }

    public Map<Category, List<Product>> groupProductsByCategory() {
        return products.stream()
                .collect(Collectors.groupingBy(Product::getCategory));
    }

    public void printAllProducts() {
        var groupedProducts = groupProductsByCategory();
        for (var category : Category.values()) {
            var products = groupedProducts.getOrDefault(category, new ArrayList<>());
            System.out.println("Категория: " + category);
            if (products.isEmpty()) {
                System.out.println("Нет продуктов.");
            } else {
                System.out.println("Продукты:");
                for (var product : products) {
                    System.out.println("- " + product.getName());
                }
            }
            System.out.println();
        }
    }
}