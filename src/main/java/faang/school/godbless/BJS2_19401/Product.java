package faang.school.godbless.BJS2_19401;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@AllArgsConstructor
public class Product {
    private int id;
    private String name;
    private String category;

    public static Map<String, List<Product>> GroupingProductsByCategory(Set<Product> productSet) {
        Map<String, List<Product>> productMap = new HashMap<>();
        List<Product> productList = new ArrayList<>();
        for (Product product : productSet) {
            if (productList.contains(product.category)) {
                productList.add(product);
                productMap.put(product.category, productList);
            } else {
                List<Product> newList = new ArrayList<>();
                productMap.put(product.category, newList);
            }
        }
        return productMap;
    }
}
