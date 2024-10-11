package school.faang.amazon;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static HashSet<Product> products = new HashSet<>();

    public static HashMap<String, List<Product>> groupByCategories() {
        return (HashMap<String, List<Product>>) products.stream()
                .collect(Collectors.groupingBy(Product::getCategory, Collectors.toList()));
    }

    public static void displayInfoOfAllProducts(HashMap<String, List<Product>> productsByCategories) {
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