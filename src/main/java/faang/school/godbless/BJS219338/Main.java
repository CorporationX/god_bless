package faang.school.godbless.BJS219338;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    private static Set<Product> products = new HashSet<>();

    public static Map<String, List<Product>> groupProductByCategory(Set<Product> products) {
        Map<String, List<Product>> groupCategory = new HashMap<>();
        for (Product product : products) {
            groupCategory.computeIfAbsent(product.getCategory(), key -> new ArrayList<>()).add(product);
        }
        return groupCategory;
    }

    public static void printAllProductGroupByCategory(Map<String, List<Product>> groupProduct) {
        for (Map.Entry<String, List<Product>> entry : groupProduct.entrySet()) {
            System.out.println("Group by category: " + entry.getKey());
            System.out.println("Product number, name and category: " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        Set<Product> products = new HashSet<>();
        products.add(new Product(1, "Apple", "Fruits"));
        products.add(new Product(2, "Banana", "Fruits"));
        products.add(new Product(3, "Potato", "Vegetables"));
        products.add(new Product(4, "Carrot", "Vegetables"));
        products.add(new Product(5, "Melon", "Fruits"));
        products.add(new Product(6, "Cucumber", "Vegetables"));

        printAllProductGroupByCategory(groupProductByCategory(products));
        System.out.println();

        products.add(new Product(7, "Water", "Drink"));
        printAllProductGroupByCategory(groupProductByCategory(products));
    }
}
