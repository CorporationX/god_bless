package faang.school.godbless.BJS24702;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
@AllArgsConstructor
public class Product {
    private int id;
    private String name;
    private String category;

    public static Map<String, List<Product>> groupProductsByCategory(Set<Product> products) {
        Map<String, List<Product>> productsByCategory = new HashMap<>();
        for (Product product : products) {
            productsByCategory.computeIfAbsent(product.getCategory(), k -> new ArrayList<>()).add(product);
        }
        return productsByCategory;
    }

    public static void printProductsByCategory(Map<String, List<Product>> productsByCategory) {
        for (Map.Entry<String, List<Product>> entry : productsByCategory.entrySet()) {
            System.out.println("Категория: " + entry.getKey());
            for (Product product : entry.getValue()) {
                System.out.println("\tID: " + product.getId() + ", Название: " + product.getName());
            }
        }
    }
}
