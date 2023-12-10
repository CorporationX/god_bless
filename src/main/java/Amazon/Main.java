package Amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    private static Set<Product> listOfProducts = new HashSet<>();

    public static void main(String[] args) {
        listOfProducts.add(new Product(1, "Phone", "Electronics"));
        listOfProducts.add(new Product(2, "Pen", "Office"));
        listOfProducts.add(new Product(3, "Tablet", "Electronics"));
        listOfProducts.add(new Product(4, "Ball", "Sport"));
        listOfProducts.add(new Product(5, "Paper", "Office"));

        Main.showAllProducts();
    }


    public static Map<String, List<Product>> sortProductsByCategory() {
        Map<String, List<Product>> sortedProducts = new HashMap<>();
        List<Product> tempList;

        for (Product product : listOfProducts) {
            tempList = sortedProducts.getOrDefault(product.getCategory(), new ArrayList<>());
            tempList.add(product);
            sortedProducts.put(product.getCategory(), tempList);
        }
        return sortedProducts;
    }

    public static void showAllProducts() {
        Map<String, List<Product>> sortedProducts = Main.sortProductsByCategory();
        for (Map.Entry<String, List<Product>> entry : sortedProducts.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }
}
