package faang.school.godbless;

import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class Main {

    private static final Set<Product> products = new HashSet<>();

    public static void main(String[] args) {

        products.add(new Product(1, "Laptop", Category.ELECTRONICS));
        products.add(new Product(2, "Headphones", Category.ELECTRONICS));
        products.add(new Product(3, "Phone", Category.ELECTRONICS));
        products.add(new Product(4, "Sofa", Category.FURNITURE));
        products.add(new Product(5, "Desk", Category.FURNITURE));
        products.add(new Product(6, "Pepsi", Category.SOFT_DRINK));
        products.add(new Product(7, "Pepsi", Category.SOFT_DRINK));
        System.out.println(getProducts(products));
        getProductByCategory();

    }

    public static Map<String, List<Product>> getProducts(Set<Product> products) {
        Map<String, List<Product>> map = new HashMap<>();
        for (Product product : products) {
            String category = product.getCategory().name();
            map.computeIfAbsent(category, k -> new ArrayList<>()).add(product);
        }
        return map;
    }


    public static void getProductByCategory() {
        Map<String, List<Product>> map = getProducts(products);
        for(Map.Entry<String, List<Product>> entry : map.entrySet()) {
            String category = entry.getKey();
            List<Product> productList = entry.getValue();
            System.out.println(category + ": " + productList);
        }
    }
}
