package faang.school.godbless.BJS2_19294;

import java.util.*;

public class Main {
    static Set<Product> productSet = new HashSet<>();

    public static void main(String[] args) {
        productSet.add(new Product(1, "Laptop", "Electronics"));
        productSet.add(new Product(2, "Table", "Furniture"));
        productSet.add(new Product(3, "Coffee Maker", "Appliances"));
        productSet.add(new Product(4, "Notebook", "Stationery"));
        productSet.add(new Product(5, "Smartphone", "Electronics"));
        productSet.add(new Product(6, "Desk Lamp", "Furniture"));
        productSet.add(new Product(7, "Blender", "Appliances"));
        productSet.add(new Product(8, "Pen", "Stationery"));
        productSet.add(new Product(9, "Headphones", "Electronics"));
        productSet.add(new Product(10, "Chair", "Furniture"));
        printByCategory(productSet);
    }

    public static HashMap<String, List<Product>> groupByCategory(Set<Product> products) {
        HashMap<String, List<Product>> result = new HashMap<>();

        for(var product : products) {
            result.computeIfAbsent(product.getCategory(), k -> new ArrayList<>()).add(product);
        }

        return result;
    }

    public static void printByCategory(Set<Product> products) {
        HashMap<String, List<Product>> grouped = groupByCategory(products);
        for(var entry : grouped.entrySet()) {
            System.out.println(entry.getKey());
            for(var product : entry.getValue()) {
                System.out.println(product);
            }
        }
    }
}
