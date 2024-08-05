package faang.school.godbless.BJS2_19346;

import java.util.*;

public class Main {

    private static Set<Product> products = new HashSet<>();

    public static void main(String[] args) {
        products.add(new Product(1, "Kettle", "Electronics"));
        products.add(new Product(2, "Processor", "Electronics"));
        products.add(new Product(3, "Blue light bulb", "Decor"));
        products.add(new Product(4, "Idk something", "Untitled category"));

        printProducts(groupProducts(products));

    }


    private static Map<String, List<Product>> groupProducts(Set<Product> products) {
        if (products.isEmpty()) {
            System.out.println("No products found");
            return null;
        }

        Map<String, List<Product>> groupedProducts = new HashMap<>();
        for (Product product : products) {
            List<Product> productGroup = groupedProducts.getOrDefault(product.getCategory(), new ArrayList<>());
            productGroup.add(product);
            groupedProducts.put(product.getCategory(), productGroup);
        }
        return groupedProducts;
    }

    private static void printProducts(Map<String, List<Product>> groupedProducts) {

        if (groupedProducts.isEmpty()) {
            System.out.println("No products found");
        }

        for (Map.Entry<String, List<Product>> entry : groupedProducts.entrySet()) {

                System.out.println(entry.getKey() + "---------------");

                for (Product product : entry.getValue()) {
                    System.out.println(product.getName());
                }
                System.out.println();
        }
    }
}
