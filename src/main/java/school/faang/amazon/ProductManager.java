package school.faang.amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ProductManager {

    private static Set<Product> products = new HashSet<>();
    private static Map<Category, List<Product>> categoryMap = new HashMap<>();

    public void addProduct(Category category, String name) {
        Product product = new Product(name, category);
        products.add(product);
        categoryMap.putIfAbsent(category, new ArrayList<>());
    }

    public void removeProduct(Category category, String name) {
        for (Product product : products) {

        }


    }
}

