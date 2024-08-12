package faang.school.godbless.BJS2_19456;

import lombok.Getter;

import java.util.*;

public class Main {
    @Getter
    private static Set<Product> products = new HashSet<>();

    public static void main(String[] args) {
    }

    public static Map<String, List<Product>> groupProductsByCategory(Set<Product> products) {
        var categories = new HashMap<String, List<Product>>();

        for (var product : products) {
            categories.computeIfAbsent(product.getCategory(), k -> new ArrayList<>()).add(product);
        }

        return categories;
    }

    public static void printProducts(Map<String, List<Product>> categories) {
        for (Map.Entry<String, List<Product>> entry : categories.entrySet()) {
            System.out.println(entry.getKey() + ":");
            for (var product : entry.getValue()) {
                System.out.println("\t" + product.getName());
            }
        }
    }
}
