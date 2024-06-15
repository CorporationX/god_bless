package faang.school.godbless.analyse_stock_amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Main {
    public static HashSet<Product> products = new HashSet<>();
    public static HashMap<String, List<Product>> productGroups = new HashMap<>();

    public static void main(String[] args) {
        products.add(new Product(1, "dress", "clothes"));
        products.add(new Product(2, "shirt", "clothes"));
        products.add(new Product(3, "boots", "shoes"));
        products.add(new Product(4, "gloves", "accessories"));
        products.add(new Product(5, "sandals", "shoes"));

        System.out.println(products);
        groupedProductsByCategory(products);
        printGroupsProductByCategory();
    }

    public static HashMap<String, List<Product>> groupedProductsByCategory(HashSet<Product> products) {
        products.forEach(product -> productGroups.computeIfAbsent(product.getCategory(), p -> new ArrayList<>()).add(product));
        return productGroups;
    }

    public static void printGroupsProductByCategory() {
        for (var entry : productGroups.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}