package faang.school.godbless.amazonStock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Main {
    static HashSet<Product> stock;

    public static void main(String[] args) {
        stock = new HashSet<>();
        stock.add(new Product(1, "iPhone 15 pro", "phone"));
        stock.add(new Product(2, "Mi max 3", "phone"));
        stock.add(new Product(3, "Asus R815", "notebook"));
        stock.add(new Product(4, "Toshiba Z15", "notebook"));
        stock.add(new Product(5, "Samsung T78-H", "tv"));
        Main.showProductsGroupByCategory(getProductsGroupByCategory(stock));
    }

    private static void showProductsGroupByCategory(Map<String, List<Product>> products) {
        for (Map.Entry<String, List<Product>> category : products.entrySet()) {
            System.out.println(category);
        }
    }

    private static Map<String, List<Product>> getProductsGroupByCategory(HashSet<Product> stock) {
        Map<String, List<Product>> productsGroupByCategory = new HashMap<>();
        for (Product product : stock) {
            productsGroupByCategory.putIfAbsent(product.getCategory(), new ArrayList<>());
            productsGroupByCategory.get(product.getCategory()).add(product);
        }
        return productsGroupByCategory;
    }
}
