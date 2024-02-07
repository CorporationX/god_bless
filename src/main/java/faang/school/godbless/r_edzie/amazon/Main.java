package faang.school.godbless.r_edzie.amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    private static final Set<Product> PRODUCTS = new HashSet<>(){{
        add(new Product(1, "Iphone", "Gadget"));
        add(new Product(2, "Ipad", "Gadget"));
        add(new Product(3, "Pizza", "Eat"));
        add(new Product(4, "Sushi", "Eat"));
        add(new Product(5, "Block", "Misc"));
    }};

    public static void main(String[] args) {
        var groupedProducts = groupByCategory(PRODUCTS);
        System.out.println(groupedProducts);
        print(groupedProducts);
    }

    public static Map<String, List<Product>> groupByCategory(Set<Product> products) {
        Map<String, List<Product>> groupedProducts = new HashMap<>();

        products.forEach(product -> {
            groupedProducts.computeIfAbsent((product.getCategory()), k -> new ArrayList<>()).add(product);
        });

        return groupedProducts;
    }

    public static void print(Map<String, List<Product>> groupedProducts) {
        for (Map.Entry<String, List<Product>> product : groupedProducts.entrySet()) {
            System.out.println(product);
        }
    }
}
