package amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Product> products = new HashSet<>();
        products.add(new Product(1, "Product 1", "Category 1"));
        products.add(new Product(2, "Product 2", "Category 2"));
        products.add(new Product(3, "Product 3", "Category 1"));
        products.add(new Product(4, "Product 4", "Category 3"));
        products.add(new Product(5, "Product 5", "Category 5"));
        products.add(new Product(6, "Product 6", "Category 7"));
        products.add(new Product(7, "Product 7", "Category 5"));
        products.add(new Product(8, "Product 8", "Category 8"));
        products.add(new Product(9, "Product 9", "Category 5"));

        Map<String, List<Product>> groupedProducts = groupedProductByCategory(products);
        printProductsByCategories(groupedProducts);
    }

    public static Map<String, List<Product>> groupedProductByCategory(Set<Product> products) {
        Map<String, List<Product>> groupedProducts = new HashMap<>();

        for (Product product : products) {
            if (!groupedProducts.containsKey(product.getCategory())) {
                groupedProducts.put(product.getCategory(), new ArrayList<>());
            }

            groupedProducts.get(product.getCategory()).add(product);
        }

        return groupedProducts;
    }

    public static void printProductsByCategories(Map<String, List<Product>> groupedProducts) {
        for(Map.Entry<String, List<Product>> entry : groupedProducts.entrySet()) {
            System.out.printf("Категория продукта: %s продукты: %s", entry.getKey(), entry.getValue().toString()).println();
        }
    }
}
