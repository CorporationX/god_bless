package faang.school.godbless;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Product> products = new HashSet<>();
        products.add(new Product(1, "Milk", "Dairy Products"));
        products.add(new Product(2, "Bread", "Bakery Category"));
        products.add(new Product(3, "Cheese", "Dairy Products"));
        products.add(new Product(4, "Apple juice", "Juices"));

        Map<String, List<Product>> groupedProducts = groupProductsByCategory(products);
        printProductsByCategory(groupedProducts);
    }

    public static Map<String, List<Product>> groupProductsByCategory(Set<Product> products) {
        Map<String, List<Product>> groupedProducts = new HashMap<>();
        Iterator<Product> iterator = products.iterator();

        while (iterator.hasNext()) {
            Product product = iterator.next();
            String category = product.getCategory();
            List<Product> productList = groupedProducts.get(category);
            if (productList == null) {
                productList = new ArrayList<>();
                groupedProducts.put(category, productList);
            }
            productList.add(product);
        }

        return groupedProducts;
    }

    public static void printProductsByCategory(Map<String, List<Product>> groupedProducts) {
        for (Map.Entry<String, List<Product>> entry : groupedProducts.entrySet()) {
            String category = entry.getKey();
            List<Product> productList = entry.getValue();

            System.out.println("Category: " + category);
            for (Product product : productList) {
                System.out.println(product);
            }
            System.out.println();
        }
    }
}
