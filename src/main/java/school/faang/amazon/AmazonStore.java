package school.faang.amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AmazonStore {

    public Map<String, List<Product>> groupProducts(Set<Product> products) {
        Map<String, List<Product>> groupProducts = new HashMap<>();
        products.forEach(
                product -> groupProducts.computeIfAbsent(product.getCategory(), category -> new ArrayList<>()).add(product)
        );
        return groupProducts;
    }

    public void printAllGroupProducts(Set<Product> products) {
        for(Map.Entry<String, List<Product>> groupProducts : groupProducts(products).entrySet()) {
            System.out.println("Group products: " + groupProducts.getKey());
            groupProducts.getValue().forEach(product -> System.out.println(" - " + product));
        }
    }
}
