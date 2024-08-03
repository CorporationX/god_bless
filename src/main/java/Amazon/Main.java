package Amazon;

import java.util.*;

public class Main {

    private static final Set<Product> PRODUCTS = new HashSet<>();
    private static Map<String, List<Product>> GROUPED_PRODUCTS = new HashMap<>();

    public static void main(String[] args) {
        PRODUCTS.add(new Product("dota", "games"));
        PRODUCTS.add(new Product("rum", "alcohol"));
        PRODUCTS.add(new Product("beer", "alcohol"));
        PRODUCTS.add(new Product("bmw", "car"));

        GROUPED_PRODUCTS = groupProducts(PRODUCTS);

        printGroupedProducts();

    }

    public static HashMap<String, List<Product>> groupProducts(Set<Product> products) {
        HashMap<String, List<Product>> grouped = new HashMap<>();
        products.forEach(product ->
        {
            grouped.putIfAbsent(product.getCategory(), new ArrayList<>());
            grouped.get(product.getCategory()).add(product);
        });
        return grouped;
    }

    public static void printGroupedProducts() {
        for (Map.Entry<String, List<Product>> entry : GROUPED_PRODUCTS.entrySet())
        {
            System.out.println(entry.getKey());
            entry.getValue().forEach((product -> System.out.println(product.getName())));
            System.out.println("_________________________________");
        }
    }
}