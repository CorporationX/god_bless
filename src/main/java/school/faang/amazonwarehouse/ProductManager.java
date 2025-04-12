package school.faang.amazonwarehouse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class ProductManager {
    private int lastIndexHolder;
    private final Set<Product> products = new HashSet<>();
    private final Map<Category, List<Product>> productsByCategory = new HashMap<>();

    public Product addProduct(Category category, String name) {
        Product product = new Product(nextIndex(), name, category);
        products.add(product);
        productsByCategory.computeIfAbsent((category), k -> new ArrayList<>());
        productsByCategory.get(category).add(product);
        return product;
    }

    public boolean removeProduct(Category category, String name) {
        List<Product> productsOfCategory = productsByCategory.get(category);
        Optional<Product> optProduct = productsOfCategory
                .stream()
                .filter(p -> p.getName().equals(name))
                .findFirst();
        if (optProduct.isPresent()) {
            Product product = optProduct.get();
            productsOfCategory.remove(product);
            return products.remove(product);
        }
        return false;
    }

    public List<Product> findProductsByCategory(Category category) {
        return productsByCategory.getOrDefault(category, Collections.emptyList());
    }

    public Map<Category, List<Product>> groupProductsByCategory() {
        return productsByCategory;
    }

    public void printAllProducts() {
        for (Map.Entry<Category, List<Product>> productsOfCategory : productsByCategory.entrySet()) {
            System.out.printf("Категория: %s \nПродукты:\n%s", productsOfCategory.getKey());
            for (Product product : productsOfCategory.getValue()) {
                System.out.println("- " + product.getName());
            }
            System.out.println();
        }
    }

    private int nextIndex() {
        return lastIndexHolder++;
    }

}