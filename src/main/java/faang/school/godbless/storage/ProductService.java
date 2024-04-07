package faang.school.godbless.storage;

import java.util.*;

public class ProductService {
    private Map<String, List<Product>> categorizedProducts = new HashMap<>();

    public Map<String, List<Product>> categorize(Set<Product> products) {
        for (Product product : products) {
            List<Product> listOfProductsInCategory = categorizedProducts.getOrDefault(product.getCategory(), new ArrayList<>());
            listOfProductsInCategory.add(product);
            categorizedProducts.put(product.getCategory(), listOfProductsInCategory);
        }
        return categorizedProducts;
    }

    public void showInfo() {
        Set<Map.Entry<String, List<Product>>> productEntries = categorizedProducts.entrySet();
        for (Map.Entry<String, List<Product>> productEntry : productEntries) {
            System.out.println(productEntry);
        }
    }
}
