package school.faang.task_45172;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Product> products = new HashSet<>();
        products.add(new Product("bread", "bakery"));
        products.add(new Product("milk", "dairy"));
        products.add(new Product("carrot", "vegetables"));
        products.add(new Product("cucumber", "vegetables"));
        products.add(new Product("tomato", "vegetables"));
        products.add(new Product("tv", "electronics"));
        products.add(new Product("jeans", "clothing"));
        products.add(new Product("cake", "dessert"));
        products.add(new Product("butter", "dairy"));
        products.add(new Product("candy", "dessert"));
        products.add(new Product("iphone", "electronics"));

        Map<String, List<Product>> map = groupProductsByCategory(products);
        printProductsByCategory(map);

    }

    public static Map<String, List<Product>> groupProductsByCategory(Set<Product> products) {
        Map<String, List<Product>> map = new HashMap<>();
        for (Product product : products) {
            map.computeIfAbsent(product.getCategory(), k -> new ArrayList<>()).add(product);
        }
        return map;
    }

    public static void printProductsByCategory(Map<String, List<Product>> map) {
        for (Map.Entry<String, List<Product>> entry : map.entrySet()) {
            System.out.print("Category: " + entry.getKey() + " -> ");
            for (Product p : entry.getValue()) {
                System.out.print(p + ", ");
            }
            System.out.println();
        }
    }
}