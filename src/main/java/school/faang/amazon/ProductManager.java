package school.faang.amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ProductManager {
    private static int id = 1;

    private final Set<Product> products = new HashSet<>();
    private final Map<Category, List<Product>> categoryToProducts = new HashMap<>();

    public static Map<Category, List<Product>> groupProductsByCategory(Set<Product> products) {
        Map<Category, List<Product>> productMap = new HashMap<>();

        for (Product product : products) {
            if (!productMap.containsKey(product.getCategory())) {
                productMap.put(product.getCategory(), new ArrayList<>());
            }
            productMap.get(product.getCategory()).add(product);
        }

        return productMap;
    }

    public void addProduct(Category category, String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Name can not be empty");
        }

        Product product = new Product(id++, name, category);
        validateDuplicateProduct(category, name);
        products.add(product);
        categoryToProducts.putIfAbsent(category, new ArrayList<>());
        categoryToProducts.get(category).add(product);
    }

    public void removeProduct(Category category, String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Name can not be empty");
        }

        products.removeIf(p -> p.getName().equals(name) && p.getCategory().equals(category));

        List<Product> products = categoryToProducts.get(category);
        if (products != null) {
            products.removeIf(p -> p.getName().equals(name));

            if (products.isEmpty()) {
                categoryToProducts.remove(category);
            }
        }
    }

    public List<Product> findProductsByCategory(Category category) {
        return categoryToProducts.get(category) != null ? categoryToProducts.get(category) : new ArrayList<>();
    }

    public void printAllProducts() {
        for (Map.Entry<Category, List<Product>> entry : categoryToProducts.entrySet()) {
            System.out.printf("Категория: %s" + "\n" + "Продукты:" + "\n", entry.getKey());
            for (Product product : entry.getValue()) {
                System.out.println(" - " + product.getName());
            }
            System.out.println();
        }
    }

    private void validateDuplicateProduct(Category category, String name) {
        for (Product p : products) {
            if (p.getName().equals(name) && p.getCategory().equals(category)) {
                throw new IllegalArgumentException("Duplicate: product: " + p.getName());
            }
        }
    }
}
