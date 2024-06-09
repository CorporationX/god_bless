package faang.school.godbless.BJS2_8291;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    static Set<Product> products = new HashSet<>();

    public static void main(String[] args) {

        Product product_1 = new Product(2, "potato", "food");
        Product product_2 = new Product(3, "audi a7", "auto");
        Product product_3 = new Product(4, "bmw x3", "auto");
        Product product_4 = new Product(5, "tomato", "food");
        Product product_5 = new Product(6, "iphone 15pro", "phone");
        Product product_6 = new Product(7, "coffee", "drink");

        products.add(product_1);
        products.add(product_2);
        products.add(product_3);
        products.add(product_4);
        products.add(product_5);
        products.add(product_6);

        Map<String, List<Product>> map = groupProductsByCategory();

        printProducts(map);
    }

    public static Map<String, List<Product>> groupProductsByCategory() {
        return products.stream()
                .collect(Collectors.groupingBy(Product::getCategory));
    }

    public static void printProducts(Map<String, List<Product>> map) {
        if (map != null) {
            map.forEach((category, products) -> {
                System.out.println("*************************");
                System.out.println("Category: " + category);
                products.forEach(System.out::println);
            });
        }
    }
}
