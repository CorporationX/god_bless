package faang.school.godbless.amazonWarehouse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Product> products = new HashSet<>();
        Product product1 = new Product(1, "product1", "category1");
        Product product2= new Product(2, "product2", "category2");
        Product product3 = new Product(3, "product3", "category3");

        products.add(product1);
        products.add(product2);
        products.add(product3);

        HashMap<String, List<Product>> productsMap = transformSetToMap(products);
        displayInfoAboutProductsInMap(productsMap);
    }

    private static HashMap<String, List<Product>> transformSetToMap(Set<Product> products) {
        HashMap<String, List<Product>> productsMap = new HashMap<>();
        for (Product product : products) {
            String productCategory = product.getCategory();
            if (!productsMap.containsKey(productCategory)) {
                productsMap.put(productCategory, new ArrayList<>());
            }
            productsMap.get(productCategory).add(product);
        }
        return productsMap;
    }

    private static void displayInfoAboutProductsInMap(HashMap<String, List<Product>> productsMap) {
        for (Map.Entry<String, List<Product>> entry : productsMap.entrySet()) {
            System.out.println("Категория товара: " + entry.getKey()
                    + ", список товаров этой категории: " + entry.getValue());
        }
    }
}