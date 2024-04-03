package faang.school.godbless.BJS2_4127;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

@Data
@AllArgsConstructor
public class Product {
    private long id;
    private String name;
    private String category;

    public static HashMap<String, List<Product>> groupProductsByCategory(HashSet<Product> products) {
        HashMap<String, List<Product>> result = new HashMap<>();

        for (Product product : products) {
            result.computeIfAbsent(product.getCategory(), k -> new ArrayList<>()).add(product);
        }

        return result;
    }

    public static void printGroupedProducts(HashMap<String, List<Product>> products) {
        for (Map.Entry<String, List<Product>> entry : products.entrySet()) {
            System.out.printf("Категория: \"%s\"", entry.getKey());
            System.out.println();

            for (Product product : entry.getValue()) {
                System.out.printf("ID: \"%s\", Название: \"%s\"", product.getId(), product.getName());
                System.out.println();
            }

        }
    }
}
