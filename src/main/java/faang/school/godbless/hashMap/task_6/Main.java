package faang.school.godbless.hashMap.task_6;

import faang.school.godbless.hashMap.task_6.model.Product;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Set<Product> products = Set.of(
                new Product(1, "name 1", "cat 1"),
                new Product(2, "name 2", "cat 2"),
                new Product(3, "name 3", "cat 1"),
                new Product(4, "name 4", "cat 3")
        );
        Map<String, List<Product>> groupingProducts = groupByCategory(products);
        printProductInfo(groupingProducts);
    }

    public static Map<String, List<Product>> groupByCategory(Set<Product> products) {
        return products.stream()
                .collect(Collectors.groupingBy(Product::getCategory));
    }

    public static void printProductInfo(Map<String, List<Product>> products) {
        products.forEach((key, value) -> {
            System.out.println("Товары категории " + key + ": ");
            value.forEach(System.out::println);
        });
    }
}