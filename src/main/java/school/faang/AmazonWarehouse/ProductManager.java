package school.faang.AmazonWarehouse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ProductManager {
    private final Set<Product> products = new HashSet<>();
    private final Map<Category, List<Product>> categoryMap = new HashMap<>();

    public void addProduct(Category category, String name) {
        Product product = new Product(name, category);
        products.add(product);

        List<Product> productList = categoryMap.computeIfAbsent(category, c -> new ArrayList<>());
        productList.add(product);
    }

    public void removeProduct(Category category, String name) {
        Product productToRemove = null;
        for (Product product : products) {
            if (product.getCategory() == category && product.getName().equals(name)) {
                productToRemove = product;
                break;
            }
        }
        if (productToRemove != null) {
            products.remove(productToRemove);
            categoryMap.get(category).remove(productToRemove);
        }
    }

    public List<Product> findProductsByCategory(Category category) {
        if (categoryMap.containsKey(category)) {
            return categoryMap.get(category);
        } else {
            return new ArrayList<>();
        }
    }

    public void groupProductsByCategory() {
        categoryMap.clear();
        for (Product product : products) {
            List<Product> productList = categoryMap.computeIfAbsent(product.getCategory(), k -> new ArrayList<>());
            productList.add(product);
        }
    }

    public void printAllProducts() {
        for (Map.Entry<Category, List<Product>> entry : categoryMap.entrySet()) {
            System.out.println("Category: " + entry.getKey());
            for (Product product : entry.getValue()) {
                System.out.println(product.getName());
            }
            System.out.println();
        }
    }
}
