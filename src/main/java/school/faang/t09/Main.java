package school.faang.t09;

import java.util.*;

public class Main {
    private static final Set<Product> PRODUCTS = new HashSet<>();

    private static Map<String, List<Product>> groupProducts(Set<Product> products) {
        Map<String, List<Product>> groupedProducts = new HashMap<>();
        for (Product product : products) {
            groupedProducts.computeIfAbsent(product.getCategory(), k -> new ArrayList<>()).add(product);
        }
        return groupedProducts;
    }

    private static void printGroupedProducts() {
        for (Map.Entry<String, List<Product>> entry: groupProducts(PRODUCTS).entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {

        Product prodOne = new Product(70, "Dog", "Pets");
        Product prodTwo = new Product(36, "Java for Dummies", "Books");
        Product prodThree = new Product(12, "Hat", "Clothes");
        Product prodFour = new Product(47, "Cat", "Pets");

        PRODUCTS.add(prodOne);
        PRODUCTS.add(prodTwo);
        PRODUCTS.add(prodThree);
        PRODUCTS.add(prodFour);

        groupProducts(PRODUCTS);
        printGroupedProducts();

    }
}
