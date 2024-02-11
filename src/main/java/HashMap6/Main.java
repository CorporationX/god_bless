package HashMap6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Product iphone = new Product(1, "iphone15", "electro");
        Product macbook = new Product(2, "macbook pro", "electro");
        Product sneakers = new Product(3, "air max", "clothes");
        Product shirt = new Product(4, "nike sb", "clothes");
        Product banana = new Product(5, "banana", "food");
        Set<Product> setProducts = Set.of(iphone, macbook, sneakers, shirt, banana);
        Map<String, List<Product>> map = groupByCategory(setProducts);
        printAllProduct(map);

    }

    public static Map<String, List<Product>> groupByCategory(Set<Product> setProducts) {
        Map<String, List<Product>> map = new HashMap<>();
        for (Product product : setProducts) {
            if (map.containsKey(product.getCategory())) {
                List<Product> products = map.get(product.getCategory());
                products.add(product);
                map.put(product.getCategory(), products);
            } else {
                List<Product> products = new ArrayList<>();
                products.add(product);
                map.put(product.getCategory(), products);
            }
        }
        return map;
    }

    public static void printAllProduct(Map<String, List<Product>> map) {
        for (Map.Entry<String, List<Product>> entry : map.entrySet()) {
            StringBuilder sb = new StringBuilder(entry.getKey()).append(": ");
            for (Product product : entry.getValue()) {
                sb.append(product.getName()).append(", ");
            }
            sb.deleteCharAt(sb.lastIndexOf(","));
            System.out.println(sb.toString());
        }
    }
}
