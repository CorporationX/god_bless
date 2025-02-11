package school.faang.amazon_store;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class ProductManager {
    private final Set<Product> products;
    private final Map<Category, List<Product>> categoryMap;
    private static int currentId = 1;

    public ProductManager() {
        products = new HashSet<>();
        categoryMap = new HashMap<>();
    }

    public void addProduct(Category category, String name) {
        var product = new Product(currentId++, name, category);
        products.add(product);
        categoryMap.putIfAbsent(category, new ArrayList<>());
        var listProducts = categoryMap.get(category);
        if (!listProducts.contains(product)) {
            listProducts.add(product);
        }
    }

    public void removeProduct(Category category, String name) {
        categoryMap.values().forEach(productList ->
                Optional.ofNullable(productList).ifPresent(list ->
                        list.removeIf(product -> product.getName().equals(name))
                )
        );
        products.removeIf(product -> product.getCategory().equals(category)
                && product.getName().equals(name));
    }

    public List findProductsByCategory(Category category) {
        return categoryMap.getOrDefault(category, null);
    }

    public void groupProductsByCategory() {
        var newMap = new HashMap<Category, List<Product>>();
        for (Product product : products) {
            newMap.putIfAbsent(product.getCategory(), new ArrayList<>());
            var listProducts = newMap.get(product.getCategory());
            if (listProducts != null) {
                listProducts.add(product);
            }
        }
        categoryMap.clear();
        categoryMap.putAll(newMap);
    }

    public void printAllProducts() {
        categoryMap.forEach((k, v) -> {
            System.out.println("Category: " + k);
            List<Product> productList = v;
            System.out.println("Products:");
            productList.forEach(product -> System.out.println(product.getId() +
                    ". " + product.getName()));
        });
    }
}
