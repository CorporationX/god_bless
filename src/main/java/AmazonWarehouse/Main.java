package AmazonWarehouse;

import java.util.*;

public class Main {
    private static final Set<Product> PRODUCTS = new HashSet<>();

    public static void main(String[] args) {
        PRODUCTS.add(new Product(2, "Футболка", "Одежда"));
        PRODUCTS.add(new Product(34, "Кроссовки", "Обувь"));
        PRODUCTS.add(new Product(21, "Блины", "Еда"));
        PRODUCTS.add(new Product(13, "Вода", "Напитки"));
        PRODUCTS.add(new Product(77, "Яблоко", "Еда"));
        PRODUCTS.add(new Product(56, "Джинсы", "Одежда"));

        groupProducts(PRODUCTS);
        printInfo(PRODUCTS);
    }

    private static Map<String, List<Product>> groupProducts(Set<Product> products) {
        Map<String, List<Product>> groupedProducts = new HashMap<>();

        for (Product product : products) {
            String key = product.getCategory();
            if (!groupedProducts.containsKey(key)) {
                groupedProducts.put(key, new ArrayList<>());
            }
            groupedProducts.get(key).add(product);
        }
        return groupedProducts;
    }

    private static void printInfo(Set<Product> products) {
        for (Map.Entry<String, List<Product>> entry : groupProducts(products).entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
