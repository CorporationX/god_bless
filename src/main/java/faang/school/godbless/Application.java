package faang.school.godbless;

import faang.school.godbless.task11.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Application {

    public static HashMap<String, List<Product>> createProductsMap(Set<Product> products) {
        HashMap<String, List<Product>> productsMap = new HashMap<>();
        for (Product product : products) {
            productsMap.computeIfAbsent(product.getCategory(), k -> new ArrayList<>()).add(product);
        }
        return productsMap;
    }

    public static void infoProducts(HashMap<String, List<Product>> products) {
        for (Map.Entry<String, List<Product>> entry: products.entrySet()) {
            System.out.println("Category " + entry.getKey());
            entry.getValue().forEach(value -> System.out.println("Value " + value));
        }
    }

    public static void main(String[] args) {
        Product product1 = new Product(1, "iphone 11", "phones");
        Product product2 = new Product(2, "iphone 13", "phones");
        Product product3 = new Product(3, "asus tuf 17", "laptop");
        HashMap<String, List<Product>> products = createProductsMap(Set.of(product1, product2, product3));
        infoProducts(products);
    }
}