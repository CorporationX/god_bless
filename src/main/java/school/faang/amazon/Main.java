package school.faang.amazon;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    private static Set<Product> products = new HashSet<>();

    public static Map<String, List<Product>> groupByCategories() {
        return products.stream()
                .collect(Collectors.groupingBy(Product::getCategory, Collectors.toList()));
    }

    public static void displayInfoOfAllProducts(Map<String, List<Product>> productsByCategories) {
        productsByCategories.entrySet().stream()
                .peek(entry -> System.out.println(entry.getKey()))
                .map(Map.Entry::getValue)
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        products.add(new Product(0, "Bike", "Games"));
        products.add(new Product(1, "Board game", "Games"));
        products.add(new Product(2, "Book", "Book"));
        products.add(new Product(3, "TV", "Electronics"));

        displayInfoOfAllProducts(groupByCategories());
    }
}