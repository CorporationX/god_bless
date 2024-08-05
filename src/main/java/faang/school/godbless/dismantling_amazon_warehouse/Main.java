package faang.school.godbless.dismantling_amazon_warehouse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Product> products = new HashSet<>();
        products.add(new Product("Laptop", "Electronics"));
        products.add(new Product("iPhone", "Electronics"));
        products.add(new Product("Tablet", "Electronics"));
        products.add(new Product("Sofa", "Furniture"));
        products.add(new Product("Chair", "Furniture"));
        products.add(new Product("Bed", "Furniture"));
        products.add(new Product("Shoes", "Clothing"));
        products.add(new Product("T-Shirt", "Clothing"));
        products.add(new Product("Sweater", "Clothing"));

        HashMap<String, List<Product>> categoryMap = groupByCategory(products);
        printProducts(categoryMap);
    }

    public static HashMap<String, List<Product>> groupByCategory(Set<Product> products) {
        HashMap<String, List<Product>> categoryMap = new HashMap<>();
        for (Product product : products) {
            String category = product.getCategory();
            if (categoryMap.containsKey(category)) {
                categoryMap.get(category).add(product);
            } else {
                List<Product> productsList = new ArrayList<>();
                productsList.add(product);
                categoryMap.put(category, productsList);
            }
        }
        return categoryMap;
    }

    public static void printProducts(Map<String, List<Product>> categoryMap) {
        for (HashMap.Entry<String, List<Product>> entry : categoryMap.entrySet()) {
            System.out.println(entry.getKey());
            for (Product product : entry.getValue()) {
                System.out.println("\t" + product.getName());

            }
        }
    }
}
