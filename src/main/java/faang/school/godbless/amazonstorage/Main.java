package faang.school.godbless.amazonstorage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

    private static Set<Product> products = new HashSet<>();

    public static void main(String[] args) {
        Product product1 = new Product(1, "Product1", "Category1");
        Product product2 = new Product(2, "Product2", "Category2");
        Product product3 = new Product(3, "Product3", "Category3");
        Product product4 = new Product(4, "Product4", "Category3");

        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);

        printAll();
    }

    public static Map<String, List<Product>> groupByCategory(Set<Product> productsSet) {
        Map<String, List<Product>> productsByCategory = new HashMap<>();
        for (var product : productsSet) {
            String category = product.getCategory();
            if (productsByCategory.get(category) == null) {
                List<Product> newProducts = new ArrayList<>();
                newProducts.add(product);
                productsByCategory.put(category, newProducts);
            }
            else {
                productsByCategory.get(category).add(product);
            }
        }
        return productsByCategory;
    }

    public static void printAll() {
        Map<String, List<Product>> productsByCategory = groupByCategory(products);
        for (var entry : productsByCategory.entrySet()) {
            System.out.println(String.format("Товары в категории \"%s\":", entry.getKey()));
            for (var product : entry.getValue()) {
                System.out.println(product.getId() + " " + product.getName());
            }
        }
    }
}
