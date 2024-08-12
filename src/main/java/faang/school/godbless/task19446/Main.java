package faang.school.godbless.task19446;

import java.util.*;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {
        Set<Product> products = new HashSet<>();
        products.add(new Product(22, "Платье", "Одежда"));
        products.add(new Product(24, "Юбка", "Одежда"));
        products.add(new Product(26, "Туфли", "Обувь"));
        products.add(new Product(28, "Сапоги", "Обувь"));

        System.out.println(groupProductByCategory(products));
        getAllProductsByCategory(products);

    }

    public static Map<String, List<Product>> groupProductByCategory(Set<Product> set){
        Map<String, List<Product>> map = new HashMap<>();
        for (Product product : set)
                map.computeIfAbsent(product.getCategory(), k -> new ArrayList<>()).add(product);
        return map;
    }

    public static void getAllProductsByCategory(Set<Product> set) {
        Map<String, List<Product>> map = groupProductByCategory(set);

        for (Map.Entry<String, List<Product>> entry : map.entrySet()) {
            String result = entry.getKey() + " - " + entry.getValue().stream()
                    .map(Product::getName).collect(Collectors.joining(", "));
            System.out.println(result);
        }
    }
}
