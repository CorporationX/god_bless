package school.faang.amazon_warehouse;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
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
        Product product = new Product(name, category);
        products.add(product);
        mapProducts = groupProductsByCategory(products);
        log.info("{} was added to warehouse", product);
    }

    public void removeItem(String category, String name) {
        if (mapProducts.containsKey(category)) {
            List<Product> productList = mapProducts.get(category);
            boolean isContains = productList.removeIf(product -> product.getName().equals(name));
            if (isContains) {
                log.info("Product {} was deleted from category {}", name, category);
            } else {
                log.info("Product {} not found in catrgory {}", name, category);
            }
        } else {
            log.info("Category {} not found", category);
        }
    }

    public void findItemsByCategory(String category) {
        if (mapProducts.containsKey(category)) {
            List<Product> productList = mapProducts.get(category);
            log.info("Category: {}", category);
            productList.forEach(product -> log.info(product.toString()));
        } else {
            log.info("Category {} not found", category);
        }
    }

    public void printAllItems() {
        printProductsByCategory(mapProducts);
    }
}
