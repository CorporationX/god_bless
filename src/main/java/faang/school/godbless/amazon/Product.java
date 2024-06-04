package faang.school.godbless.amazon;

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

    public static Map<String, List<Product>> groupByCategory(Set<Product> products){
        Map<String, List<Product>> result = new HashMap<>();

        for(Product product : products){
            result.computeIfAbsent(product.category, categoryAsKey -> new ArrayList<>());
            result.get(product.category).add(product);
        }

        return result;
    }

    public static void showAllProductsGroupedByCategory(Map<String, List<Product>> productMap){
        for(Map.Entry<String, List<Product>> categoryEntry : productMap.entrySet()){
            System.out.println("Products of " + categoryEntry.getKey());
            for(Product product : categoryEntry.getValue()){
                System.out.println(product);
            }
        }
    }
}
