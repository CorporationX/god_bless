package faang.school.godbless.amazon;

import java.util.*;

public class ProductService {

    /*public static HashMap<String, List<Product>> groupProductsByCategory(HashSet<Product> products) {
        return products.stream()
                .collect(Collectors.groupingBy(Product::getCategory, HashMap::new, Collectors.toList()));
    }*/

    public static HashMap<String, List<Product>> groupProductsByCategory(HashSet<Product> products) {

        HashMap<String, List<Product>> groupedProducts = new HashMap<>();

        for (Product product : products) {

            List<Product> productList = groupedProducts.get(product.getCategory());
            if (productList == null) {
                productList = new ArrayList<>();
                groupedProducts.put(product.getCategory(), productList);
            }
            productList.add(product);
        }

        return groupedProducts;
    }

    public static void printProducts(HashMap<String, List<Product>> products) {
        for (Map.Entry<String, List<Product>> product : products.entrySet()) {
            System.out.println("Category " + product.getKey());
            System.out.println("Products " + product.getValue());
        }
    }
}
