package school.faang.sort_amazon_warehouse;

import java.util.*;

public class ProductManager {
    private int currentId = 0;
    private final Set<Product> products = new HashSet<>();

    public void addProduct(Category category, String name) {
        for (Product product : products) {
            if (product.getName().equals(name) && product.getCategory().equals(category)) {
                System.out.println("Product with this name exist in category: " + category);
                return;
            }
        }
        Product product = new Product(currentId++, name, category);
        products.add(product);
        System.out.println("Product: " + product.getName() + "Add in category: " + product.getCategory());
    }

    public void removeProduct(Category category, String name) {
        Product product = new Product(currentId, name, category);
        products.remove(product);
            }

    public List<Product> findProductsByCategory(Category category) {
        List<Product> productList = new ArrayList<>();

        for (Product product : products) {
            if (product.getCategory().equals(category)) {
                productList.add(product);
            }
        }

        return productList;
    }

    public Map<Category, List<Product>> groupProductsByCategory() {
        Map<Category, List<Product>> productMap = new HashMap<>();
        for (Product product : products) {
            Category category = product.getCategory();
            productMap.computeIfAbsent(category, k -> new ArrayList<>()).add(product);
        }

        return productMap;

    }

    public void printAllProducts() {
        Map<Category, List<Product>> result = groupProductsByCategory();
        for (Map.Entry<Category, List<Product>> entry : result.entrySet()) {
            System.out.println("Category: " + entry.getKey());
            System.out.println("Products: ");
            for (Product product : entry.getValue()) {
                System.out.println(" - " + product.getName());
            }
            System.out.println();
        }

    }
}
