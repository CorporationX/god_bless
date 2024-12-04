package school.faang.task_45102;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Set<Product> products = new HashSet<>();
        products.add(new Product("bread", "bakery", 10));
        products.add(new Product("milk", "dairy", 15));
        products.add(new Product("carrot", "vegetables", 30));
        products.add(new Product("cucumber", "vegetables", 50));
        products.add(new Product("tomato", "vegetables", 30));
        products.add(new Product("tv", "electronics", 2));
        products.add(new Product("jeans", "clothing", 5));
        products.add(new Product("cake", "dessert", 10));
        products.add(new Product("butter", "dairy", 15));
        products.add(new Product("candy", "dessert", 99));
        products.add(new Product("iphone", "electronics", 5));

        Map<String, List<Product>> map = groupProductsByCategory(products);
        printProductsByCategory(map);

    }

    public static Map<String, List<Product>> groupProductsByCategory(Set<Product> products) {
        Map<String, List<Product>> map = new HashMap<>();
        for (Product product : products) {
            List<Product> list = map.putIfAbsent(product.getCategory(), new ArrayList<>());
            if (list != null) {
                list.add(product);
            } else {
                map.get(product.getCategory()).add(product);
            }
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
