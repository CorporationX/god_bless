package school.faang.task45150.service;

import school.faang.task45150.model.Product;

import java.util.*;

public class ProductCatalogue {

    private static int productId = 1;
    Map<String, List<Product>> groupedProducts = new HashMap<>();

    public void addItem(String category, String name) {
        Product product = new Product(productId++, category, name);
        groupedProducts.computeIfAbsent(category, k -> new ArrayList<>()).add(product);
    }

    public void removeItem(String category, String name) {
        List<Product> productList = groupedProducts.get(category);
        productList.removeIf(product -> product.getName().equals(name));
    }

    public List<Product> findItemsByCategory(String category) {
        return groupedProducts.get(category);
    }

    public void printAllItems() {
        System.out.println("ALL PRODUCT LIST: ");

        for (Map.Entry<String, List<Product>> entry : groupedProducts.entrySet()) {
            System.out.println(">>> " + entry.getKey());
            for (Product product : entry.getValue()) {
                System.out.println(product);
            }
        }
    }

}
