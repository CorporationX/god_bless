package faang.school.godbless.AmazonStorage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Product product1 = new Product(1, "Sofa", "Furniture");
        Product product2 = new Product(2, "Divan", "Furniture");
        Product product3 = new Product(3, "TV", "Tech");
        Set<Product> productSet = new HashSet<>(Set.of(product1, product2, product3));
        main.groupProducts(productSet);

    }

    public Map<String, List<Product>> groupProducts(Set<Product> products){
        Map<String, List<Product>> groupedProducts = new HashMap<>();
        for (Product product  : products) {
            String category = product.getCategory();
            groupedProducts.putIfAbsent(category, new ArrayList<>());
            groupedProducts.get(category).add(product);
        }
        for (Map.Entry<String, List<Product>> entry : groupedProducts.entrySet()) {
            String category = entry.getKey();
            List<Product> productsList = entry.getValue();
            System.out.println("\nCategory: " + category);
            for (Product product : productsList) {
                System.out.println("\t" + product);
            }
        }
        return groupedProducts;
    }


}
