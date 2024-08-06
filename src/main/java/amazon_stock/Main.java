package amazon_stock;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Main {

    private static final HashSet<Product> products = new HashSet<>();

    public static void main(String[] args) {
        products.add(new Product(1, "Smartphone", "Technology"));
        products.add(new Product(2, "Smartwatch", "Technology"));
        products.add(new Product(3, "G.Oruwell '1984'", "Book"));
        products.add(new Product(4, "Clean Code", "Book"));
        products.add(new Product(5, "Black T-shirt", "Cloths"));

        printInfoAboutProducts(groupProductsByCategory(products));
    }

    public static HashMap<String, List<Product>> groupProductsByCategory(HashSet<Product> products) {
        HashMap<String, List<Product>> productsByCategory = new HashMap<>();
        for (Product product : products) {
            if (!productsByCategory.containsKey(product.getCategory())) {
                productsByCategory.put(product.getCategory(), new ArrayList<>());
            }
            productsByCategory.get(product.getCategory()).add(product);
        }
        return productsByCategory;
    }


    public static void printInfoAboutProducts(HashMap<String, List<Product>> productsByCategory) {
        for (Map.Entry<String, List<Product>> category : productsByCategory.entrySet()) {
            System.out.printf("Товары с категорией %s: %s\n", category.getKey(), category.getValue().toString());
        }
    }
}
