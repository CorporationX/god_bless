package faang.school.godbless.AmazonStorage2040;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    static Set<Product> products = new HashSet<>();
    static int id = 1;

    public static void main(String[] args) {
        addNewProduct(Categories.HOME.getCategory(), "Couch");
        addNewProduct(Categories.HOME.getCategory(), "Table");
        addNewProduct(Categories.HOME.getCategory(), "Carpet");
        addNewProduct(Categories.ELECTRONICS.getCategory(), "Laptop");
        addNewProduct(Categories.ELECTRONICS.getCategory(), "Phone");
        addNewProduct(Categories.SPORT.getCategory(), "Ball");
        addNewProduct(Categories.SPORT.getCategory(), "Bicycle");
        addNewProduct(Categories.FOR_CHILDREN.getCategory(), "Baby buggy");
        addNewProduct(Categories.HOME.getCategory(), "Chandelier");

        System.out.println("TEST 1: Added 9 products");
        System.out.println(products.toString());

        System.out.println("TEST 2: Group them");
        Map<String, List<Product>> groupedProducts = groupProducts(products);
        System.out.println(groupedProducts);

        System.out.println("TEST 3: Testing printAllProductsInfo method");
        printAllProductsInfo(groupedProducts);

    }

    public static void addNewProduct(String category, String name) {
        products.add(new Product(id, category, name));
        id++;
    }

    public static Map<String, List<Product>> groupProducts(Set<Product> products) {
        Map<String, List<Product>> result = new HashMap<>();
        for (Product product : products) {
            String key = product.getCategory();
            if (!(result.containsKey(key))) {
                result.put(key, new ArrayList<>());
            }
            result.get(key).add(product);
        }
        return result;
    }

    public static void printAllProductsInfo(Map<String, List<Product>> groupedProducts) {
        for (var entry : groupedProducts.entrySet()) {
            System.out.printf("""
                    Products category : %s
                    Products list : %s
                    """, entry.getKey(), entry.getValue().toString());
        }
    }
}
