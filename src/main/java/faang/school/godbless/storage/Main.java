package faang.school.godbless.storage;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        ProductService productService = new ProductService();
        Set<Product> productsSet = new HashSet<>();
        Product product1 = new Product(1, "Apple", "Fruits");
        Product product2 = new Product(2, "Pear", "Fruits");
        Product product3 = new Product(3, "Cola", "Drinks");
        Product product4 = new Product(4, "Juice", "Drinks");
        Product product5 = new Product(5, "Cucumber", "Vegetables");

        productsSet.add(product1);
        productsSet.add(product2);
        productsSet.add(product3);
        productsSet.add(product4);
        productsSet.add(product5);

        productService.categorize(productsSet);

        productService.showInfo();
    }
}
