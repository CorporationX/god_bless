package school.faang.task45150;

import school.faang.task45150.model.Product;
import school.faang.task45150.service.ProductCatalogue;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Set<Product> productSet = new HashSet<>();

        productSet.add(new Product(1, "Dairy", "Milk"));
        productSet.add(new Product(2, "Dairy", "Icecream"));
        productSet.add(new Product(3, "Dairy", "Yogurht"));
        productSet.add(new Product(4, "Deserts", "Chocolate"));
        productSet.add(new Product(5, "Deserts", "Cracker"));
        productSet.add(new Product(6, "Alcohol", "Wine"));
        productSet.add(new Product(7, "Alcohol", "Beer"));

        printProductsByCategory(groupProductsByCategory(productSet));

        ProductCatalogue productCatalogue = getProductCatalogue();

        System.out.println();
        System.out.println("Product catalog before deleting products:");
        productCatalogue.printAllItems();

        productCatalogue.removeItem("Fruits", "Orange");

        System.out.println();
        System.out.println("Product catalog after deleting products:");
        productCatalogue.printAllItems();

        System.out.println();
        System.out.println("All products in category Fruits:");
        System.out.println(productCatalogue.findItemsByCategory("Fruits"));

        System.out.println("All products in category Water:");
        System.out.println(productCatalogue.findItemsByCategory("Water"));
    }

    private static ProductCatalogue getProductCatalogue() {

        ProductCatalogue productCatalogue = new ProductCatalogue();

        productCatalogue.addItem("Fruits", "Apple");
        productCatalogue.addItem("Fruits", "Orange");
        productCatalogue.addItem("Fruits", "Citrus");
        productCatalogue.addItem("Water", "Limonade");
        productCatalogue.addItem("Water", "Water");
        productCatalogue.addItem("Water", "Juice");
        productCatalogue.addItem("Vegetables", "Potato");
        productCatalogue.addItem("Vegetables", "Porridge");

        return productCatalogue;
    }

    public static Map<String, List<Product>> groupProductsByCategory(Set<Product> products) {
        Map<String, List<Product>> groupedProducts = new HashMap<>();
        for (Product product : products) {
            groupedProducts.computeIfAbsent(product.getCategory(), k -> new ArrayList<>()).add(product);
        }
        return groupedProducts;
    }

    public static void printProductsByCategory(Map<String, List<Product>> groupedProducts) {
        System.out.println();
        System.out.println("CUSTOM PRODUCT LIST: ");
        for (Map.Entry<String, List<Product>> entry : groupedProducts.entrySet()) {
            System.out.println(">>> " + entry.getKey());
            for (Product product : entry.getValue()) {
                System.out.println(product);
            }
        }
    }
}
