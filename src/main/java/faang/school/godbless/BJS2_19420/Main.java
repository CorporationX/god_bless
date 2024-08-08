package faang.school.godbless.BJS2_19420;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Main {
    private static HashSet<Product> products = new HashSet<>();

    public static void main(String[] args) {
        products.add(new Product(1, "Laptop", "Electronics"));
        products.add(new Product(2, "Chair", "Furniture"));
        products.add(new Product(3, "Phone", "Electronics"));
        products.add(new Product(4, "Book", "Stationery"));
        HashMap<String, List<Product>> groupedProducts = groupProductsByCategory(products);
        printProductsByCategories(groupedProducts);
    }

    private static HashMap<String, List<Product>> groupProductsByCategory(HashSet<Product> products) {
        if (products == null) {
            return null;
        }
        HashMap<String, List<Product>> groupedProducts = new HashMap<>();
        for (Product product : products) {
            groupedProducts.computeIfAbsent(product.getCategory(), category -> new ArrayList<>()).add(product);
        }
        return groupedProducts;
    }

    private static void printProductsByCategories(HashMap<String, List<Product>> groupedProducts) {
        if (groupedProducts != null) {
            for (var groupedProduct : groupedProducts.entrySet()) {
                System.out.println("Category: " + groupedProduct.getKey());
                if (groupedProduct.getValue() != null) {
                    for (Product product : groupedProduct.getValue()) {
                        System.out.println(product);
                    }
                }
            }
        }
    }
}
