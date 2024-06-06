package faang.school.godbless;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class Main {
    private static final Set<Product> PRODUCTS = new HashSet<>();

    public Map<String, List<Product>> groupByCategory(Set<Product> products) {
        Objects.requireNonNull(products);
        Map<String, List<Product>> map = new HashMap<>();

        for (Product product : products) {
            String category = product.getCategory();
            map.putIfAbsent(category, new ArrayList<>());
            map.get(category).add(product);
        }

        return map;
    }

    public void printAllProducts(Map<String, List<Product>> map) {
        Objects.requireNonNull(map);
        map.values().forEach(System.out::println);
    }
}
