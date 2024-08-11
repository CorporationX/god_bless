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
        getAllProducts(products);
        System.out.println(findProductByCategory(products, "Одежда"));
    }

    public static Map<String, List<Product>> groupProductByCategory(Set<Product> set){
        Map<String, List<Product>> map = new HashMap<>();
        for (Product product : set)
                map.computeIfAbsent(product.getCategory(), k -> new ArrayList<>()).add(product);
        return map;
    }

    public static void getAllProducts(Set<Product> set){
        Map<String, List<Product>> map = groupProductByCategory(set);
        map.entrySet().stream()
                .flatMap(entry -> entry.getValue().stream())
                .forEach(product -> System.out.println(product.getCategory() + product.getName()));
    }

    public static List<Product> findProductByCategory(Set<Product> set, String category){
        List<Product> result = set.stream().filter(product -> product.getCategory().equals(category))
                .collect(Collectors.toList());
        return  result;
    }

}
