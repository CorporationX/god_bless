package faang.school.godbless.task.amazon.warehouse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ProductManager {

    public Map<String, List<Product>> groupingByCategory(Set<Product> productSet) {
        Map<String, List<Product>> categoryProductsListMap = new HashMap<>();
        productSet.forEach(product ->
                categoryProductsListMap.computeIfAbsent(product.category(),
                        k -> new ArrayList<>()).add(product));
        return categoryProductsListMap;
    }
}
