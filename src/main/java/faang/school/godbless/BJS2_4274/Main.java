package faang.school.godbless.BJS2_4274;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    private static final Map<String, List<Product>> PRODUCTS = new HashMap<>();

    public static void main(String[] args) {
        Main main = new Main();

        Set<Product> products = new HashSet<>();

        Product nokia = new Product("Nokia", "Phone");
        Product ikea = new Product("Ikea", "Furniture");
        Product hp = new Product("Hp", "Technic");
        Product macBook = new Product("MacBook", "Technic");
        Product chair = new Product("Chair", "Furniture");
        Product table = new Product("Table", "Furniture");

        products.add(nokia);
        products.add(ikea);
        products.add(hp);
        products.add(macBook);
        products.add(chair);
        products.add(table);

        main.groupByCategory(products)
                .printAllProducts();
    }

    private Main groupByCategory(Set<Product> products) {
        for (Product product : products) {
            PRODUCTS.computeIfAbsent(product.getCategory(), key -> new ArrayList<>()).add(product);
        }
        return this;
    }

    private void printAllProducts() {
        for (var entry : PRODUCTS.entrySet()) {
            System.out.println("Category: " + entry.getKey());
            entry.getValue().forEach(System.out::println);
        }
    }
}
