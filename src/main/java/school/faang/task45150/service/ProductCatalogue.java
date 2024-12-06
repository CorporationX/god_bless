package school.faang.task45150.service;

import school.faang.task45150.model.Product;

import java.util.*;

public class ProductCatalogue {
    private static int productId = 1;
    private final Map<String, List<Product>> groupedByCategoryProducts = new HashMap<>();

    public void addItem(String category, String name) {
        Product product = new Product(productId++, category, name);
        groupedByCategoryProducts.computeIfAbsent(category, k -> new ArrayList<>()).add(product);
    }

    public void removeItem(String category, String name) {
        if (category.isEmpty()) throw new IllegalArgumentException("Category is empty");
        if (name.isEmpty()) throw new IllegalArgumentException("Name is empty");

        List<Product> productList = groupedByCategoryProducts.get(category);
        if (productList != null) {
            productList.removeIf(product -> product.getName().equals(name));
        }
    }

    public List<Product> findItemsByCategory(String category) {
        return groupedByCategoryProducts.get(category);
    }

    public void printAllItems() {
        System.out.println("ALL PRODUCT LIST: ");

        for (Map.Entry<String, List<Product>> entry : groupedByCategoryProducts.entrySet()) {
            System.out.println(">>> " + entry.getKey());
            for (Product product : entry.getValue()) {
                System.out.println(product);
            }
        }
    }

}
