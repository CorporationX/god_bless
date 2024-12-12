package school.faang.amazon_warehouse;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RequiredArgsConstructor
@Setter
@Getter
@Slf4j
public class Warehouse {
    private final Set<Product> products;
    private Map<String, List<Product>> mapProducts;

    public Map<String, List<Product>> groupProductsByCategory(Set<Product> products) {
        Map<String, List<Product>> mapByCategory = new HashMap<>();
        products.forEach(product ->
                mapByCategory.computeIfAbsent(product.getCategory(), k -> new ArrayList<>()).add(product)
        );
        return mapByCategory;
    }

    public void printProductsByCategory(Map<String, List<Product>> groupedProducts) {
        groupedProducts.forEach((category, list) -> {
            log.info("Category: {}", category);
            list.forEach(product -> log.info("# {}", product));
        });
    }

    public void addItem(String category, String name) {

    }

//    public void printAllItems() {
//        products.forEach(System.out::println);
//    }
}
