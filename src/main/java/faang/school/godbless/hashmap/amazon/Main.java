package faang.school.godbless.hashmap.amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

public class Main {
    private final Set<Product> productsSet = new HashSet<>();

    public Map<String, List<Product>> groupProductsByCategory(Set<Product> products) {
        return products.stream().collect(groupingBy(
                Product::category,
                HashMap::new,
                toList()));
    }

    public void addProductsToCategory(Set<Product> productsSet, Map<String, List<Product>> productsMap) {
        productsSet.forEach(element ->
                productsMap.computeIfAbsent(element.category(), v -> new ArrayList<>()).add(element));
    }

    public void printProducts(Map<String, List<Product>> productsMap) {
        productsMap.entrySet().forEach(entry ->
                System.out.println("Category: " + entry.getKey() + " Products: " + entry.getValue()));
    }
}
