package faang.school.godbless.amazon.warehouse;

import java.util.*;

public class Main {

    private static Set<Product> products = new HashSet<>();

    public static Map<String, List<Product>> groupedProducts(Set<Product> products) {
        Map<String, List<Product>> groupedProducts = new HashMap<>();
        for(Product product : products) {
            String key = product.getCategory();
            groupedProducts.computeIfAbsent(key, k -> new ArrayList<>()).add(product);
        }
        return groupedProducts;
    }

    public static void printGroupedProducts(Map<String, List<Product>> groupedProducts) {
        for(Map.Entry<String, List<Product>> entry : groupedProducts.entrySet()) {
            System.out.println(entry.getKey());
            for(Product product : entry.getValue()) {
                System.out.println("\t" + product.getName());
            }
        }
    }
    public static void main(String[] args) {
        products.add(new Product(1, "name1", "category1"));
        products.add(new Product(2, "name2", "category2"));
        products.add(new Product(3, "name3", "category3"));
        products.add(new Product(4, "name4", "category1"));
        products.add(new Product(5, "name5", "category2"));

        Map<String, List<Product>> groupedProducts = groupedProducts(products);
        printGroupedProducts(groupedProducts);

    }
}
