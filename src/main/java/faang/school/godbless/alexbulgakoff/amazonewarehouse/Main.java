package faang.school.godbless.alexbulgakoff.amazonewarehouse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Alexander Bulgakov
 */

public class Main {

    private static final Set<Product> PRODUCTS = new HashSet<>();

    private static final Map<String, List<Product>> WAREHOUSE = new HashMap<>();

    public static void main(String[] args) {
        Product telephone = new Product(256741, "Android Phone", Category.SMARTPHONE);
        Product mirror = new Product(864572, "Mirror Car", Category.CAR_THINGS);
        Product monitor = new Product(256741, "Huawei DFS-45", Category.COMPUTER);
        Product book = new Product(113782, "Cook Book", Category.BOOK);
        Product schoolbag = new Product(189512, "School Bag", Category.SCHOOL_SUPPLIES);
        Product uniform = new Product(189550, "School Form", Category.SCHOOL_SUPPLIES);

        PRODUCTS.add(telephone);
        PRODUCTS.add(monitor);
        PRODUCTS.add(mirror);
        PRODUCTS.add(uniform);
        PRODUCTS.add(schoolbag);
        PRODUCTS.add(book);

        System.out.println(PRODUCTS);

        //new line
        System.out.println();

        //grouping products by category
        groupingProductsByCategory(PRODUCTS);
        System.out.println(WAREHOUSE);

        //new line
        System.out.println();

        //get product by category
        getProductInfoByCategory(Category.SCHOOL_SUPPLIES.toString());
    }

    public static Map<String, List<Product>> groupingProductsByCategory(Set<Product> products) {
        for (Product product : products) {
            WAREHOUSE.putIfAbsent(product.getCategory().toString(), new ArrayList<>());
            WAREHOUSE.get(product.getCategory().toString()).add(product);
        }
        return WAREHOUSE;
    }

    public static void getProductInfoByCategory(String category) {
        for (Map.Entry<String, List<Product>> entry : WAREHOUSE.entrySet()) {
            if (entry.getKey().equals(category)) {
                System.out.println("Category: " + entry.getKey() + "\n" + "Product: " + entry.getValue() + "\n");
            }
        }
    }
}
