package faang.school.godbless.bjs219615;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Product> products = new HashSet<>();
        Map<String, List<Product>> groupedProducts = new HashMap<>();

        products.add(new Product(1, "Echo Dot", "Electronics"));
        products.add(new Product(2, "Fire TV Stick", "Electronics"));
        products.add(new Product(3, "Kindle Paperwhite", "Books"));
        products.add(new Product(4, "AmazonBasics Laptop Sleeve", "Accessories"));
        products.add(new Product(5, "Alexa Smart Plug", "Smart Home"));
        groupedProducts = ProductManager.groupProductsByCategory(products);
        ProductManager.printProducts(groupedProducts);
    }
}
