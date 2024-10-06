package school.faang.amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        String category1 = "Мебель";
        String category2 = "Техника";
        String category3 = "Продукты питания";

        Product product1 = new Product(1, "Стол", category1);
        Product product2 = new Product(1, "Кресло", category1);
        Product product3 = new Product(1, "Ноутбук", category2);
        Product product4 = new Product(1, "Мышь", category2);
        Product product5 = new Product(1, "Банан", category3);
        Product product6 = new Product(1, "Яблоко", category3);

        Set<Product> products = new HashSet<>(Set.of(product1, product2, product3, product4, product5, product6));
        Map<String, List<Product>> categoryToProducts = groupByCategory(products);
        print(categoryToProducts);
    }

    public static Map<String, List<Product>> groupByCategory(Set<Product> products) {
        Map<String, List<Product>> categoryToProducts = new HashMap<>();
        for (Product product : products) {
            List<Product> productList = categoryToProducts.getOrDefault(product.getCategory(), new ArrayList<>());
            productList.add(product);
            categoryToProducts.put(product.getCategory(), productList);
        }
        return categoryToProducts;
    }

    public static void print(Map<String, List<Product>> categoryToProducts) {
        for (Map.Entry<String, List<Product>> entry : categoryToProducts.entrySet()) {
            String category = entry.getKey();
            List<Product> productList = entry.getValue();
            System.out.println(category + ": " + productList);
        }
    }
}
