package faang.school.godbless.amazon_stock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Set<Product> products = Set.of(
                new Product("bread", "food"),
                new Product("milk", "drinks"),
                new Product("tomato", "food"),
                new Product("potato", "food"),
                new Product("phone", "electronic"),
                new Product("macbook", "electronic")
        );

        printInfoAboutProducts(groupingProducts(products));
    }

    public static Map<String, List<Product>> groupingProducts(Set<Product> products) {
        Map<String, List<Product>> productMap = new HashMap<>();
        for (Product product : products) {

            /*
            Как лучше писать, как тут или как в закомменченом коде?
            Результат один, но возможно есть какие-то моменты
            */
            productMap.putIfAbsent(product.getCategory(), new ArrayList<>());
            productMap.get(product.getCategory()).add(product);

//            if (!productMap.containsKey(product.getCategory())) {
//                productMap.put(product.getCategory(), new ArrayList<>());
//            }
//            productMap.get(product.getCategory()).add(product);
        }
        return productMap;
    }

    public static void printInfoAboutProducts(Map<String, List<Product>> map) {
        map.forEach((k, v) -> System.out.printf("%s -> %s%n", k, v));
    }

}
