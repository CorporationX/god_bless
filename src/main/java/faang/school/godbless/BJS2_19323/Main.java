package faang.school.godbless.BJS2_19323;

import java.util.*;

public class Main {
    private static Set<Product> products = new HashSet<>();

    public static void main(String[] args) {
        products.add(new Product(1, "Hp", "Notebooks"));
        products.add(new Product(1, "LG", "TV"));
        products.add(new Product(1, "IBM", "Notebooks"));
        products.add(new Product(1, "Sony", "TV"));
        products.add(new Product(1, "Benq", "Monitors"));
        products.add(new Product(1, "Panasonic", "TV"));
        products.add(new Product(1, "MSI", "Monitors"));
        products.add(new Product(1, "Lenovo", "Notebooks"));
        products.add(new Product(1, "Samsung", "Monitors"));

        Map<String, List<Product>> productGroups = groupingByCategory(products);
        productGroups.forEach((category, products) -> {
            System.out.println(category+":");
            products.forEach(product -> System.out.println(product.getName()));
            System.out.println("------------");
        });
    }

    public static Map<String, List<Product>> groupingByCategory(Set<Product> products) {
        Map<String, List<Product>> groups = new HashMap<>();
        products.forEach(product -> {
            if (!groups.containsKey(product.getCategory())) {
                groups.put(product.getCategory(), new ArrayList<>(List.of(product)));
            } else {
                groups.get(product.getCategory()).add(product);
            }
        });
        return groups;
    }
}
