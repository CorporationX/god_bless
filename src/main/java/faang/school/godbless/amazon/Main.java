package faang.school.godbless.amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Main {
    private static HashSet<Product> products = new HashSet<>();
    public static void main(String... args) {
        products.add(new Product(1, "War and Peace", "books"));
        products.add(new Product(2, "Song of Ice and Fire", "books"));
        products.add(new Product(3, "Harry Potter & Java source", "books"));
        products.add(new Product(4, "apple", "vegetables"));
        products.add(new Product(5, "banana", "vegetables"));
        products.add(new Product(6, "orange", "vegetables"));
        printAllCategoryProducts();
        products.add(new Product(7, "watermelon", "vegetables"));
        printAllCategoryProducts();
    }

    public static HashMap<String, List<Product>> groupProducts() {
        HashMap<String, List<Product>> result = new HashMap<>();
        for (Product product : products) {
            List<Product> productList = result.get(product.getCategory());
            if (productList == null) {
                productList = new ArrayList<>();
            }
            productList.add(product);
            result.put(product.getCategory(), productList);
        }
        return result;
    }

    public static void printAllCategoryProducts() {
        HashMap<String, List<Product>> categoryMap = groupProducts();
        for (Map.Entry<String, List<Product>> entry : categoryMap.entrySet()) {
            System.out.println(String.format("Products in category \"%s\" are:", entry.getKey()));
            for (Product product : entry.getValue()) {
                System.out.println(product.getName());
            }
        }
    }
}
