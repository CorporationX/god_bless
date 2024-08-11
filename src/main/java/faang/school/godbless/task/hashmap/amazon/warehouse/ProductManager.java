package faang.school.godbless.task.hashmap.amazon.warehouse;

import lombok.AllArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@AllArgsConstructor
public class ProductManager {
    @Setter
    private Set<Product> productSet;

    public Map<String, List<Product>> groupingByCategory(Set<Product> productSet) {
        Map<String, List<Product>> categoryProductsListMap = new HashMap<>();
        productSet.forEach(product ->
                categoryProductsListMap.computeIfAbsent(product.category(),
                        k -> new ArrayList<>()).add(product));
        return categoryProductsListMap;
    }

    public void printProductsByCategory() {
        groupingByCategory(productSet).entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + ":");
            entry.getValue().forEach(product -> System.out.println(product));
        });
    }
}
