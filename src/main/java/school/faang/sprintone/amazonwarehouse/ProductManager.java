package school.faang.sprintone.amazonwarehouse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ProductManager {
    private final Set<Product> products;

    public ProductManager() {
        this.products = new HashSet<>();
    }

    public void addProduct(Category category, String name) {
        Product product = new Product(name, category);
        products.add(product);
        System.out.printf("Продукт: %s добавлен.%n", name);
    }

    public void removeProduct(Category category, String name) {
        for (Product product : products) {
            if (product.getCategory() == category && product.getName().equals(name)) {
                products.remove(product);
                System.out.printf("Продукт: %s удален.", name);
                break;
            }
        }
    }

    public List<Product> findProductsByCategory(Category category) {
        List<Product> productList = new ArrayList<>();
        for (Product product : products) {
            if (product.getCategory().equals(category)) {
                productList.add(product);
            }
        }
        return productList.isEmpty() ? Collections.emptyList() : productList;
    }

    public Map<Category, List<Product>> groupProductsByCategory() {
        return products.stream().collect(Collectors.groupingBy(Product::getCategory));
    }

    public void printAllProducts() {
        Map<Category, List<Product>> productsByCategory = groupProductsByCategory();

        for (Map.Entry<Category, List<Product>> entry : productsByCategory.entrySet()) {
            System.out.printf("Категория: %s%n", entry.getKey());
            System.out.println("Продукты:");

            for (Product product : entry.getValue()) {
                System.out.printf("- %s%n", product.getName());
            }

            System.out.println();
        }
    }
}