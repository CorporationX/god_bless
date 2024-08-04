package faang.school.godbless.BJS2_19304;

import java.util.*;

public class Main {
    private final Set<Product> products = new HashSet<>();

    {
        products.add(new Product(1, "Playstation 4", "Console"));
        products.add(new Product(2, "Xbox 360", "Console"));
        products.add(new Product(3, "Playstation 5", "Console"));
        products.add(new Product(4, "Samsung", "TV"));
        products.add(new Product(5, "LG", "TV"));
        products.add(new Product(6, "Sony", "TV"));
        products.add(new Product(7, "Toyota", "Car"));
        products.add(new Product(8, "Honda", "Car"));
        products.add(new Product(9, "Subaru", "Car"));
    }

    public Map<String, List<Product>> groupProducts(Set<Product> products) {
        Map<String, List<Product>> result = new HashMap<>();
        for (Product product : products) {
            result.merge(product.getCategory(), new ArrayList<>(List.of(product)),
                    (x, y) -> {
                        x.addAll(y);
                        return x;
                    });
        }
        return result;
    }

    public void printProducts() {
        groupProducts(products).forEach((category, list) -> {
            System.out.println("-" + category + " :");
            list.forEach(p -> System.out.println("---" + p));
        });
    }
}
