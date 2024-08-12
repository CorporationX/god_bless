package faang.school.godbless.bjs2_19373;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.Collections.singletonList;
import static java.util.stream.Collectors.groupingBy;

public class Main {
    public static void main(String[] args) {
        var products = new HashSet<Product>();
        products.add(new Product(1, "1", "cat1"));
        products.add(new Product(2, "2", "cat1"));
        products.add(new Product(3, "3", "cat2"));
        products.add(new Product(4, "4", "cat3"));
        products.add(new Product(5, "5", "cat3"));

        var groupedProducts = groupProducts(products);
        print(groupedProducts);
        System.out.println("----------------");

        var groupedProductsJava8 = groupProductsJava8(products);
        print(groupedProductsJava8);
    }

    private static Map<String, List<Product>> groupProducts(Set<Product> products) {
        var groupedProducts = new HashMap<String, List<Product>>();
        var iterator = products.iterator();
        while (iterator.hasNext()) {
            var p = iterator.next();
            var category = p.getCategory();
            if (!groupedProducts.containsKey(category)) {
                groupedProducts.put(category, new ArrayList<>(singletonList(p)));
            } else {
                groupedProducts.get(category).add(p);
            }
        }
        return groupedProducts;
    }

    private static Map<String, List<Product>> groupProductsJava8(Set<Product> products) {
        return products.stream().collect(groupingBy(Product::getCategory));
    }

    private static void print(Map<String, List<Product>> groupedProducts) {
        for (Map.Entry<String, List<Product>> entry : groupedProducts.entrySet()) {
            System.out.println("Category: " + entry.getKey());
            printProducts(entry.getValue());
        }
    }

    private static void printProducts(List<Product> products) {
        for (Product product : products) {
            System.out.println("    " + product.toString());
        }
    }
}
