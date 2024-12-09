package school.faang.amazon_warehouse;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RequiredArgsConstructor
public class Warehouse {
    @Getter
    private final Set<Product> products;

//    public Map<String, List<Product>> groupProductsByCategory(Set<Product> products) {
//        Map<String, List<Product>> mapByCategory = new HashMap<>();
//        products.forEach(product ->
//                mapByCategory.computeIfAbsent(product.category(), k -> new ArrayList<>()).add(product)
//        );
//        return mapByCategory;
//    }

    public void printProductsByCategory(Map<String, List<Product>> groupedProducts) {
        groupedProducts.forEach((category, list) ->
                System.out.println("Category: " + category + "\n" + list)
        );
    }

    public void addItem(String category, String name) {

    }

//    public void printAllItems() {
//        products.forEach(System.out::println);
//    }
}
