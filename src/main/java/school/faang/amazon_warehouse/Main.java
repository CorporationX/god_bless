package school.faang.amazon_warehouse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        var products = Set.of(
                new Product(1, "IPhone", "Phones"),
                new Product(4, "Samsung", "Phones"),
                new Product(5, "Mouse", "PC"),
                new Product(6, "Monitor", "PC"),
                new Product(8, "RAM", "PC"),
                new Product(3, "Ball", "Sport"),
                new Product(2, "Bar", "Sport")
        );

        groupProductsByCategory(products).entrySet().forEach(System.out::println);
    }

    private static Map<String, List<Product>> groupProductsByCategory(Set<Product> products) {
        var groupedProducts = new HashMap<String, List<Product>>();
        products.forEach(product -> groupedProducts.put(product.getCategory(), products.stream()
                .filter(eachProduct -> eachProduct.getCategory().equalsIgnoreCase(product.getCategory()))
                .toList()));
        return groupedProducts;
    }
}
