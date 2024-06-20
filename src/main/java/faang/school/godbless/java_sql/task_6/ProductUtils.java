package faang.school.godbless.java_sql.task_6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class ProductUtils {
    static HashMap<String, List<Product>> groupProductsByCategory(HashSet<Product> products) {
        HashMap<String, List<Product>> productsMap = new HashMap<>();
        products.forEach(product -> productsMap.computeIfAbsent(product.category(),
                k -> new ArrayList<>()).add(product));
        return productsMap;
    }

    static void printProductsDescription(HashMap<String, List<Product>> productsMap) {
        productsMap.keySet().forEach(key -> System.out.println("Category: " + key + ", products: " + productsMap.get(key)));
    }
}
