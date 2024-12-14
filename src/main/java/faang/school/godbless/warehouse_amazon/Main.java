package faang.school.godbless.warehouse_amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

    public static Set<Product> productSet = new HashSet<>();

    public static void main(String[] args) {
        productSet.add(new Product(1, "product", "category"));
        productSet.add(new Product(2, "product2", "category1"));
        productSet.add(new Product(3, "product3", "category"));
        productSet.add(new Product(4, "product4", "category1"));
        productSet.add(new Product(5, "product5", "category2"));

        Map<String, List<Product>> productMap = groupProductByCategory();

        printAllProductInfo(productMap);
    }

    public static Map<String, List<Product>> groupProductByCategory() {
        Map<String, List<Product>> groupProductMap = new HashMap<>();

        for (Product product : productSet) {
            if (!groupProductMap.containsKey(product.getCategory())) {
                groupProductMap.put(product.getCategory(), new ArrayList<>(List.of(product)));
            } else {
                groupProductMap.get(product.getCategory()).add(product);
            }
        }

        return groupProductMap;
    }

    public static void printAllProductInfo(Map<String, List<Product>> map) {
        for (Map.Entry<String, List<Product>> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}