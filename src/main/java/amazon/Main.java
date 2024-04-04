package amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

    private static final Set<Product> PRODUCT_SET = new HashSet<>();
    private static final Map<String, List<Product>> PRODUCTS_BY_CATEGORY = new HashMap<>();

    public static void main(String[] args) {
        Product product1 = new Product(1, "Tomato", "Vegetables");
        Product product2 = new Product(2, "Cucumber", "Vegetables");

        Product product3 = new Product(3, "Apple", "Fruits");
        Product product4 = new Product(4, "Watermelon", "Fruits");
        Product product5 = new Product(5, "Mango", "Fruits");
        Product product6 = new Product(6, "Banana", "Fruits");

        Product product7 = new Product(7, "Milk", "Milk");
        Product product8 = new Product(8, "Cream", "Milk");

        Product product9 = new Product(9, "Carrot", "Vegetables");
        Product product10 = new Product(10, "Cabbage", "Vegetables");
        Product product11 = new Product(11, "Potato", "Vegetables");

        PRODUCT_SET.add(product1);
        PRODUCT_SET.add(product2);
        PRODUCT_SET.add(product3);
        PRODUCT_SET.add(product4);
        PRODUCT_SET.add(product5);
        PRODUCT_SET.add(product6);
        PRODUCT_SET.add(product7);
        PRODUCT_SET.add(product8);
        PRODUCT_SET.add(product9);
        PRODUCT_SET.add(product10);
        PRODUCT_SET.add(product11);

        printAllCategory(groupProductByCategory(PRODUCT_SET));
    }

    public static Map<String, List<Product>> groupProductByCategory(Set<Product> products) {
        List<Product> tmp;
        String key;
        for (Product product : products) {
            key = product.getCategory();
            if (!PRODUCTS_BY_CATEGORY.containsKey(key)) {
                PRODUCTS_BY_CATEGORY.put(key, new ArrayList<>());
            }
            tmp = PRODUCTS_BY_CATEGORY.get(key);
            tmp.add(product);
            PRODUCTS_BY_CATEGORY.put(key, tmp);
        }
        return PRODUCTS_BY_CATEGORY;
    }

    public static void printAllCategory(Map<String, List<Product>> productsByCategory) {
        for (Map.Entry<String, List<Product>> entry : productsByCategory.entrySet()) {
            System.out.println("Category: " + entry.getKey() +
                    "\n===============");
            for (Product product : entry.getValue()) {
                System.out.println("ID: " + product.getId() +
                        "\nName: " + product.getName() + "\n");
            }
            System.out.println("===============\n");
        }
    }
}
