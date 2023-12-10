package faang.school.godbless.amazon_storage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

    private static Set<Product> products;

    public static void main(String[] args) {

        Product pen = new Product("Pen", "Office");
        Product pencil = new Product( "Pencil", "Office");
        Product pan = new Product("Pan", "Kitchen");
        Product pot = new Product("Pot", "Kitchen");
        Product spoon = new Product("Spoon", "Kitchen");
        Product shirt = new Product("Shirt", "Cloth");
        Product jeans = new Product("Jeans", "Cloth");

        products = Set.of(pen, pencil, pan, pot, spoon, shirt, jeans);

        getAllProducts(groupProductsByCategory(products));
    }

    public static Map<String, List<Product>> groupProductsByCategory(Set<Product> set) {

        Map<String, List<Product>> sortedProducts = new HashMap<>();

        for (Product product : set) {
            sortedProducts.putIfAbsent(product.getCategory(), new ArrayList<>());
            sortedProducts.get(product.getCategory()).add(product);
        }
        return sortedProducts;
    }

    public static void getAllProducts(Map<String, List<Product>> map) {
        for(Map.Entry<String, List<Product>> entry : map.entrySet()) {
            System.out.println("Category: " + entry.getKey() + ", " +
                    "Products: " + entry.getValue());
        }
    }

}
