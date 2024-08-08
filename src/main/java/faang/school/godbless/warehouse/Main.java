package faang.school.godbless.warehouse;

import java.util.*;

public class Main {
    private static Set<Product> productSet = new HashSet<>();

    public static void addProduct(Product product) {
        productSet.add(product);
    }

    public static HashMap<String, List<Product>> groupProducts(){
        HashMap<String, List<Product>> groupedProducts = new HashMap<>();
        for (Product product : productSet) {
            if (!groupedProducts.containsKey(product.getCategory())) {
                groupedProducts.put(product.getCategory(), new ArrayList<>(List.of(product)));
            } else {
                groupedProducts.get(product.getCategory()).add(product);
            }
        }
        return groupedProducts;
    }

    public static void printProductsGroupedByCategory(){
        HashMap<String, List<Product>> groupedProducts = groupProducts();
        for (Map.Entry<String, List<Product>> entry : groupedProducts.entrySet()) {
            for (Product product : entry.getValue()) {
                System.out.println(entry.getKey() + ": " + product);
            }
        }
    }

    public static void main(String[] args) {
        addProduct(new Product(1,"iphone", "tech"));
        addProduct(new Product(2,"macbook", "tech"));
        addProduct(new Product(3,"shirt", "clothes"));
        addProduct(new Product(4, "dress", "clothes"));
        addProduct(new Product(5,"airpods", "tech"));
        addProduct(new Product(6,"bread", "food"));
        addProduct(new Product(7,"milk", "food"));
        addProduct(new Product(8,"couch", "furniture"));
        addProduct(new Product(9,"apple", "food"));
        addProduct(new Product(10,"desk", "furniture"));

        printProductsGroupedByCategory();
    }
}
