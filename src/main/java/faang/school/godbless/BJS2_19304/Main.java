package faang.school.godbless.BJS2_19304;

import lombok.Getter;

import java.util.*;

@Getter
public class Main {
    private final Set<Product> products = new HashSet<>();

    public Map<String, List<Product>> groupedProducts(Set<Product> products) {
        Map<String, List<Product>> result = new HashMap<>();
        for (Product product : products) {
            result.computeIfAbsent(product.getCategory(), k -> new ArrayList<>()).add(product);
        }
        return result;
    }

    public void printProducts() {
        groupedProducts(products).forEach((category, list) -> {
            System.out.println("-" + category + " :");
            list.forEach(p -> System.out.println("---" + p));
        });
    }
}
